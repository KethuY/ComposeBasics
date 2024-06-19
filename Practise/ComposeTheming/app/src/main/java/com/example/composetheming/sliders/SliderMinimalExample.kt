package com.example.composetheming.sliders

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var sliderPosition1 by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
        Spacer(modifier = Modifier.padding(16.dp))
        Slider(
            value = sliderPosition1,
            onValueChange = { sliderPosition1 = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 5,
            valueRange = 0f..50f
        )
        Text(text = sliderPosition1.toString())
        Spacer(modifier = Modifier.padding(16.dp))
        var sliderPosition2 by remember { mutableStateOf(0f..100f) }

        Column {
            RangeSlider(
                value = sliderPosition2,
                steps = 5,
                valueRange = 0f..50f,
                onValueChange = { range -> sliderPosition2 = range },
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
            )
            Text(text = sliderPosition2.toString())
        }
    }
}
