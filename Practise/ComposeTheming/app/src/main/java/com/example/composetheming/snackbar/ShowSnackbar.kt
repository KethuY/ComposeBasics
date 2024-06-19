package com.example.composetheming.snackbar

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun ShowSnackbar(
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                icon = { Icon(Icons.Filled.Info, contentDescription = "") },
                onClick = {
                    scope.launch {
                      val res=  snackbarHostState.showSnackbar("Snackbar", duration = SnackbarDuration.Short, actionLabel = "Action")
                       when(res){
                           SnackbarResult.ActionPerformed -> {
                               snackbarHostState.showSnackbar("Action Performed")
                           }
                           SnackbarResult.Dismissed -> {
                               snackbarHostState.showSnackbar("Dismissed")
                           }
                       }
                    }
                }
            )
        }
    ) { contentPadding ->
        // Screen content
        Text(
            text = "Snackbar example",
            modifier = modifier.padding(contentPadding)
        )
    }

}

@Preview(name = "ShowSnackbar")
@Composable
private fun PreviewShowSnackbar() {
    ShowSnackbar()
}