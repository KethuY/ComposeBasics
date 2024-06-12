package com.adib.mobile.ui2.home.payments.inttxfr.transfer

import com.adib.mobile.BaseNewClientMockDependencies
import com.adib.mobile.app.AdibApp
import com.adib.mobile.datamodel.Beneficiary
import com.adib.mobile.datamodel.ExternalBeneficiary
import com.adib.mobile.datamodel.OtherBank
import com.adib.mobile.datamodel.OwnAccount
import com.adib.mobile.datamodel.Purpose
import com.adib.mobile.datamodel.SavingsAccount
import com.adib.mobile.datamodel.Transfer
import com.adib.mobile.model.RoutingNostro
import com.adib.mobile.model.TransferRate
import com.adib.mobile.model.internalacctransfer.TransferRateRequest
import com.adib.mobile.networkmodule.util.NetworkState
import com.adib.mobile.ui2.Resource
import com.adib.mobile.ui2.home.payments.inttxfr.Util
import com.adib.mobile.ui2.home.payments.inttxfr.interactor.OwnAccountsInteractor
import com.adib.mobile.ui2.home.payments.inttxfr.interactor.TransferRateAndPurposeInteractor
import com.adib.mobile.ui2.home.payments.inttxfr.repository.WalletRepository
import com.adib.mobile.ui2.home.payments.inttxfr.repository.entertransferamount.AmountEnteringRepository
import com.adib.mobile.ui2.home.payments.inttxfr.utils.TransferOfflineApiPath
import com.adib.mobile.ui2.home.transfer.wallets.WalletInteractor
import com.adib.mobile.usecase.accounts.BaseFactory
import com.adib.mobile.usecase.transfer.LoadPayerAccountsResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

/**
 * Created by Kethu on 12/06/2024.
 */

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(PowerMockRunner::class)
@PrepareForTest(
    OwnAccountsInteractor::class,
    WalletInteractor::class,
    TransferRateAndPurposeInteractor::class,
    WalletRepository::class,
    AmountEnteringRepository::class

)
class BeneficiaryAmountEnteringViewModelTest : BaseNewClientMockDependencies() {
    private lateinit var bundleDataModel: BundleDataModel
    private lateinit var viewModel: BeneficiaryAmountEnteringViewModel

    @Mock
    lateinit var ownInteractor: OwnAccountsInteractor

    lateinit var walletInteractor: WalletInteractor

    lateinit var transferInteractor: TransferRateAndPurposeInteractor

    @Mock
    lateinit var walletRepo: WalletRepository

    @Mock
    lateinit var amountRepos: AmountEnteringRepository

    private val testCoroutineDispatcher = StandardTestDispatcher()

    override fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
        filePathList = listOf(TransferOfflineApiPath.TRANSFER_RATE)
        super.setup()
        walletInteractor = WalletInteractor(walletRepo)
        transferInteractor = TransferRateAndPurposeInteractor(amountRepos)
        viewModel = BeneficiaryAmountEnteringViewModel(
            transferInteractor,
            ownInteractor,
            walletInteractor
        )
        saveTransferData()
    }

    @Test
    fun `test FetchOwnAccountsAndCards event Success response`() = runTest {
        PowerMockito.`when`(
            ownInteractor.fetchOwnAccountsAndCards(
                AdibApp.getAppContext(),
                getNotNullTransfer()
            )
        ).thenReturn(flowOf(Resource.Success(getLoadPayAccounts(), NetworkState.SUCCESS)))
        viewModel.onEvent(BeneficiaryAmountEnteringScreenEvent.FetchOwnAccountsAndCards)
        val state = viewModel.state.first() as BeneficiaryAmountEnteringUIState.OwnAccountFetched
        Assert.assertNotNull(state.accountCardsUIData)
    }

    @Test
    fun `test FetchOwnAccountsAndCards event with failure response`() = runTest {
        val transfer = getNotNullTransfer()
        PowerMockito.`when`(
            ownInteractor.fetchOwnAccountsAndCards(
                AdibApp.getAppContext(),
                transfer
            )
        ).thenReturn(flowOf(Resource.Network(NetworkState.FAILED)))
        viewModel.onEvent(BeneficiaryAmountEnteringScreenEvent.FetchOwnAccountsAndCards)
        val response = ownInteractor.fetchOwnAccountsAndCards(
            AdibApp.getAppContext(),
            transfer
        ).first()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.networkState == NetworkState.FAILED)
        Assert.assertNull(viewModel.onNetworkCallFailed.value)
    }

    @Test
    fun `test FetchTransferRate event with success response when transfer doesn't have own account`() = runTest {
        val transfer = getNotNullTransfer()
        PowerMockito.`when`(amountRepos.fetchTransferRate(TransferRateRequest()))
            .thenReturn(flowOf(Resource.Network(NetworkState.FAILED)))

        viewModel.onEvent(BeneficiaryAmountEnteringScreenEvent.FetchTransferRate)
        val response = transferInteractor.fetchTransferRate(
            transfer
        ).first()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.apiNetworkState() == NetworkState.SUCCESS)
        Assert.assertNotNull(response.getResponse())
    }

    @Test
    fun `test FetchTransferRate event with success response when transfer has own account with number is empty`() = runTest {
        val transfer = getNotNullTransfer()
        transfer.ownAccount = SavingsAccount()
        PowerMockito.`when`(amountRepos.fetchTransferRate(TransferRateRequest()))
            .thenReturn(flowOf(Resource.Network(NetworkState.FAILED)))

        viewModel.onEvent(BeneficiaryAmountEnteringScreenEvent.FetchTransferRate)
        val response = transferInteractor.fetchTransferRate(
            transfer
        ).first()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.apiNetworkState() == NetworkState.SUCCESS)
        Assert.assertNotNull(response.getResponse())
    }

    @Test
    fun `test FetchTransferRate event with Failure response when transfer has valid own account`() = runTest {
        val transfer = getNotNullTransfer()
        transfer.ownAccount = SavingsAccount().apply {
            number = "020301546015"
        }
        PowerMockito.`when`(amountRepos.fetchTransferRate(TransferRateRequest()))
            .thenReturn(flowOf(Resource.Network(NetworkState.FAILED,data = null)))

        viewModel.onEvent(BeneficiaryAmountEnteringScreenEvent.FetchTransferRate)
        val response = transferInteractor.fetchTransferRate(
            transfer
        ).first()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.apiNetworkState() == NetworkState.FAILED)
        Assert.assertNull(viewModel.onNetworkCallFailed.value)
      /*  val response = transferInteractor.fetchTransferRate(
            transfer
        ).first()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.apiNetworkState() == NetworkState.FAILED)*/
    }

    @Test
    fun `test FetchTransferRate event when user has single account`() {
      //  interactor.fetchTransferRate(it)
    }

    @Test
    fun `test FetchTransferRate event when user has multiple accounts and is repeat transfer`() {

    }

    private fun saveTransferData() = runTest {
        bundleDataModel = BundleDataModel(
            transfer = Transfer<OwnAccount, Beneficiary>().apply {
                beneficiary = getExtBeneficiary()
                purpose = Purpose().apply {
                    description = "Education"
                    code = "EDU"
                }
            },
        )
        viewModel.onEvent(BeneficiaryAmountEnteringScreenEvent.DataFromBundle(bundleDataModel))
        val state = viewModel.state.first() as BeneficiaryAmountEnteringUIState.InitializeViews
        Assert.assertFalse(state.isRepeatTransfer)
        Assert.assertNotNull(state.dataUIModel)
    }

    private fun getExtBeneficiary() = ExternalBeneficiary().apply {
        number = "020301546015"
        bank = OtherBank().apply {
            name = "ICICI Bank"
            with(country) {
                name = "India"
                countryIso3 = "IND"
                nameCode = "IND"
                currency = "INR"
            }
        }
        name = "Satya kethu"
        beneficiaryId = "123455"
        currency = BaseFactory.createCurrency("INR")
        nostroCurrency = RoutingNostro().apply {
            currencyCode = "INR"
            countryIso3 = "IND"
            currencyDesc = "Indian Rupee"
        }
    }

    private fun getLoadPayAccounts() = LoadPayerAccountsResult().apply {
        ownAccounts = listOf(SavingsAccount())
    }

    private fun getNotNullTransfer() = bundleDataModel.transfer ?: Transfer()

    private fun getTransferRate() = Gson().fromJson<TransferRate>(
        Util.getDataFromJson(adibApp.assets, TransferOfflineApiPath.TRANSFER_RATE),
        object : TypeToken<TransferRate>() {}.type
    )
}