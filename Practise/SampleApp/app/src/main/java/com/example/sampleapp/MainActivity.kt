package com.example.sampleapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.sampleapp.constaraint.ConstraintLayoutScreen
import com.example.sampleapp.ui.theme.Purple40
import com.example.sampleapp.ui.theme.SampleAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAppTheme {
                Scaffold {
                    //ListItem()
                   // IndianFlagScreen()
                    //MovieBookingScreen()
                    ConstraintLayoutScreen()
                }
            }
        }
    }
    @Composable
    fun MovieBookingScreen() {
        Surface(color = Color.White) {
            ConstraintLayout(
                modifier = Modifier.fillMaxSize(),
            ) {
                val (
                    menuButton, coverImage, titleText, genreText, ratingText,
                    castText, castContainer, castImage1, castImage2, castImage3, castImage4,
                    descText, bottomSurface, bookButton, cinemaNameContainer,
                ) = createRefs()

                Icon(
                    painter = painterResource(id = R.drawable.ic_bg0),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .constrainAs(menuButton) {
                            start.linkTo(parent.start, 16.dp)
                            top.linkTo(parent.top, 16.dp)
                        }
                )

                val rightGuideline = createGuidelineFromStart(0.4f)

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .constrainAs(coverImage) {
                            start.linkTo(parent.start, 24.dp)
                            top.linkTo(menuButton.bottom, 16.dp)
                            end.linkTo(rightGuideline, 16.dp)
                            width = Dimension.fillToConstraints
                        }
                        .aspectRatio(2f / 3f),
                )

                Text(
                    text = "Deadpool",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(titleText) {
                        top.linkTo(menuButton.bottom, 8.dp)
                        start.linkTo(coverImage.end, 16.dp)
                    }
                )

                Text(
                    text = "Action | 1h 48m",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.constrainAs(genreText) {
                        top.linkTo(titleText.bottom)
                        start.linkTo(coverImage.end, 16.dp)
                    }
                )

                Text(
                    text = "IMDb 8.0/10",
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.constrainAs(ratingText) {
                        top.linkTo(genreText.bottom, 16.dp)
                        start.linkTo(coverImage.end, 16.dp)
                    }
                )

                Text(
                    text = "CAST",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(castText) {
                        bottom.linkTo(castContainer.top)
                        start.linkTo(coverImage.end, 16.dp)
                    }
                )

                ConstraintLayout(modifier = Modifier.constrainAs(castContainer) {
                    bottom.linkTo(coverImage.bottom)
                    start.linkTo(coverImage.end, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.fillToConstraints
                })
                {
                    Image(
                        painter = painterResource(id = R.drawable.ic_bg1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(50.dp)
                            .constrainAs(castImage1) {
                                bottom.linkTo(coverImage.bottom)
                                start.linkTo(coverImage.end, 16.dp)
                            }
                            .aspectRatio(1f)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_bg2),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(50.dp)
                            .constrainAs(castImage2) {
                                top.linkTo(castImage1.top)
                                bottom.linkTo(castImage1.bottom)
                                start.linkTo(castImage1.end)
                            }
                            .aspectRatio(1f)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_bg3),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(50.dp)
                            .constrainAs(castImage3) {
                                top.linkTo(castImage1.top)
                                bottom.linkTo(castImage1.bottom)
                                start.linkTo(castImage2.end)
                            }
                            .aspectRatio(1f)
                    )

                    Box(modifier = Modifier
                        .height(50.dp)
                        .background(color = colorResource(id = R.color.purple_200))
                        .constrainAs(castImage4) {
                            top.linkTo(castImage1.top)
                            bottom.linkTo(castImage1.bottom)
                            start.linkTo(castImage3.end)
                            end.linkTo(parent.end, 16.dp)
                        }
                        .aspectRatio(1f)) {
                        Text(
                            text = "+9",
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .align(Alignment.Center),
                            color = Color.Black
                        )
                    }

                    createHorizontalChain(
                        castImage1, castImage2, castImage3, castImage4,
                        chainStyle = ChainStyle.SpreadInside
                    )
                }

                val barrier = createBottomBarrier(coverImage, castContainer)

                Text(
                    text = stringResource(id = R.string.task_details),
                    color = Color(0x8A000000),
                    fontSize = 16.sp,
                    modifier = Modifier.constrainAs(descText) {
                        top.linkTo(barrier, 36.dp)
                        start.linkTo(parent.start, 24.dp)
                        end.linkTo(parent.end, 24.dp)
                        width = Dimension.preferredWrapContent
                    }
                )

                Surface(color = colorResource(id = R.color.teal_200),
                    modifier = Modifier.constrainAs(bottomSurface) {
                        top.linkTo(descText.bottom, 36.dp)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
                ) {}


                val (date1, date2, date3, date4, date5, date6, date7,
                    day1, day2, day3, day4, day5, day6, day7, dateSelector, dateMarker) = createRefs()

                val selectedDateStartState = remember { mutableStateOf(day1.start) }
                val selectedDateEndState = remember { mutableStateOf(day1.end) }

                Surface(
                    color = Color.White,
                    modifier = Modifier
                        .constrainAs(dateSelector) {
                            top.linkTo(descText.bottom, 36.dp)
                            start.linkTo(selectedDateStartState.value)
                            end.linkTo(selectedDateEndState.value)
                            bottom.linkTo(day1.bottom)
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        }
                ) {}

                Surface(
                    color = Color.Black,
                    modifier = Modifier
                        .height(4.dp)
                        .constrainAs(dateMarker) {
                            top.linkTo(dateSelector.top)
                            start.linkTo(dateSelector.start)
                            end.linkTo(dateSelector.end)
                            width = Dimension.fillToConstraints
                        }
                ) {}

                Text(
                    text = "20",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .constrainAs(date1) {
                            top.linkTo(descText.bottom, 52.dp)
                            start.linkTo(day1.start)
                            end.linkTo(day1.end)
                        }
                        .clickable {
                            selectedDateStartState.value = day1.start
                            selectedDateEndState.value = day1.end
                        }
                )

                Text(
                    text = "21",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .constrainAs(date2) {
                            top.linkTo(date1.top)
                            bottom.linkTo(date1.bottom)
                            start.linkTo(day2.start)
                            end.linkTo(day2.end)
                        }
                        .clickable {
                            selectedDateStartState.value = day2.start
                            selectedDateEndState.value = day2.end
                        }
                )

                Text(
                    text = "22",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .constrainAs(date3) {
                            top.linkTo(date1.top)
                            bottom.linkTo(date1.bottom)
                            start.linkTo(day3.start)
                            end.linkTo(day3.end)
                        }
                        .clickable {
                            selectedDateStartState.value = day3.start
                            selectedDateEndState.value = day3.end
                        }
                )

                Text(
                    text = "23",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .constrainAs(date4) {
                            top.linkTo(date1.top)
                            bottom.linkTo(date1.bottom)
                            start.linkTo(day4.start)
                            end.linkTo(day4.end)
                        }
                        .clickable {
                            selectedDateStartState.value = day4.start
                            selectedDateEndState.value = day4.end
                        }
                )

                Text(
                    text = "24",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .constrainAs(date5) {
                            top.linkTo(date1.top)
                            bottom.linkTo(date1.bottom)
                            start.linkTo(day5.start)
                            end.linkTo(day5.end)
                        }
                        .clickable {
                            selectedDateStartState.value = day5.start
                            selectedDateEndState.value = day5.end
                        }
                )

                Text(
                    text = "25",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .constrainAs(date6) {
                            top.linkTo(date1.top)
                            bottom.linkTo(date1.bottom)
                            start.linkTo(day6.start)
                            end.linkTo(day6.end)
                        }
                        .clickable {
                            selectedDateStartState.value = day6.start
                            selectedDateEndState.value = day6.end
                        }
                )

                Text(
                    text = "26",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .constrainAs(date7) {
                            top.linkTo(date1.top)
                            bottom.linkTo(date1.bottom)
                            start.linkTo(day7.start)
                            end.linkTo(day7.end)
                        }
                        .clickable {
                            selectedDateStartState.value = day7.start
                            selectedDateEndState.value = day7.end
                        }
                )


                Text(
                    text = "SUN",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.purple_200),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                        .constrainAs(day1) {
                            top.linkTo(date1.bottom, 16.dp)
                        }
                        .clickable {
                            selectedDateStartState.value = day1.start
                            selectedDateEndState.value = day1.end
                        }
                )

                Text(
                    text = "MON",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.purple_200),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                        .constrainAs(day2) {
                            top.linkTo(day1.top)
                            bottom.linkTo(day1.bottom)
                        }
                        .clickable {
                            selectedDateStartState.value = day2.start
                            selectedDateEndState.value = day2.end
                        }
                )

                Text(
                    text = "TUE",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.purple_200),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                        .constrainAs(day3) {
                            top.linkTo(day1.top)
                            bottom.linkTo(day1.bottom)
                        }
                        .clickable {
                            selectedDateStartState.value = day3.start
                            selectedDateEndState.value = day3.end
                        }
                )

                Text(
                    text = "WED",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.purple_200),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                        .constrainAs(day4) {
                            top.linkTo(day1.top)
                            bottom.linkTo(day1.bottom)
                        }
                        .clickable {
                            selectedDateStartState.value = day4.start
                            selectedDateEndState.value = day4.end
                        }
                )

                Text(
                    text = "THU",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.purple_200),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                        .constrainAs(day5) {
                            top.linkTo(day1.top)
                            bottom.linkTo(day1.bottom)
                        }
                        .clickable {
                            selectedDateStartState.value = day5.start
                            selectedDateEndState.value = day5.end
                        }
                )

                Text(
                    text = "FRI",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.purple_200),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                        .constrainAs(day6) {
                            top.linkTo(day1.top)
                            bottom.linkTo(day1.bottom)
                        }
                        .clickable {
                            selectedDateStartState.value = day6.start
                            selectedDateEndState.value = day6.end
                        }
                )

                Text(
                    text = "SAT",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.purple_200),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                        .constrainAs(day7) {
                            top.linkTo(day1.top)
                            bottom.linkTo(day1.bottom)
                        }
                        .clickable {
                            selectedDateStartState.value = day7.start
                            selectedDateEndState.value = day7.end
                        }
                )

                createHorizontalChain(day1, day2, day3, day4, day5, day6, day7)

                ConstraintLayout(modifier = Modifier.constrainAs(cinemaNameContainer) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(dateSelector.bottom, 16.dp)
                    bottom.linkTo(bookButton.top, 16.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                })
                {
                    val (cinemaNameText, cinemaDistText) = createRefs()

                    Text(
                        text = "Velocity Cinema",
                        fontSize = 22.sp,
                        color = Color(0xDD000000),
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.constrainAs(cinemaNameText) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                    )

                    Text(
                        text = "4.6 km",
                        fontSize = 14.sp,
                        color = Color(0x8A000000),
                        modifier = Modifier.constrainAs(cinemaDistText) {
                            start.linkTo(cinemaNameText.start)
                            end.linkTo(cinemaNameText.end)
                            width = Dimension.fillToConstraints
                        }
                    )

                    createVerticalChain(cinemaNameText, cinemaDistText, chainStyle = ChainStyle.Packed)
                }


                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.purple_700)),
                    modifier = Modifier
                        .height(60.dp)
                        .background(color = colorResource(id = R.color.purple_700))
                        .constrainAs(bookButton) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                ) {
                    Text(
                        text = "BOOK TICKETS",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }

    @Composable
    fun IndianFlagScreen() {
        ConstraintLayout {
            val constraints = ConstraintSet {
                val orangeBox = createRefFor("orangebox")
                val greenBox = createRefFor("greenbox")
                val circle = createRefFor("circle")

                constrain(orangeBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(circle.top)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(260.dp)
                }
                constrain(circle) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
                constrain(greenBox) {
                    top.linkTo(circle.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(260.dp)
                }
                createVerticalChain(orangeBox, circle, greenBox, chainStyle = ChainStyle.SpreadInside)
            }
            ConstraintLayout(constraints, modifier = Modifier
                .background(Color.White)
                .fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFFFB8C00))
                        .layoutId("orangebox")
                )
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .layoutId("circle")
                )
                Box(
                    modifier = Modifier
                        .background(Color(0xFF2EB734))
                        .layoutId("greenbox")
                )
            }
        }
    }

    @Composable
    fun ListItem() {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()

                .background(color = Purple40)
                .padding(8.dp)
        ) {
            // Create references for the composables to constrain
            val (image, title, subtitle, icon, text, trailIcon) = createRefs()
            val rightGuideline = createGuidelineFromStart(0.2f)
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(8.dp)
                    .size(64.dp)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        width = Dimension.fillToConstraints
                    }
            )

            Text(
                "Title",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(rightGuideline, 8.dp)
                    top.linkTo(image.top)
                }
            )

            Text(
                "Subtitle",
                color = Color.White,
                fontSize = 14.sp,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.constrainAs(subtitle) {
                    start.linkTo(rightGuideline, 8.dp)
                    top.linkTo(title.bottom)
                }
            )

            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = null,
                modifier = Modifier.constrainAs(icon) {
                    start.linkTo(rightGuideline, 8.dp)
                    top.linkTo(subtitle.bottom)
                    bottom.linkTo(parent.bottom)
                })

            Text(
                "Account number * 2014",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.constrainAs(text) {
                    top.linkTo(subtitle.bottom)
                    start.linkTo(icon.end, 8.dp)
                    bottom.linkTo(parent.bottom)
                }
            )

            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = null,
                modifier = Modifier.constrainAs(trailIcon) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)
                })

        }
    }

    @Preview
    @Composable
    fun ConstraintLayoutContent1() {
        MovieBookingScreen()
    }
}
