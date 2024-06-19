package com.example.composetheming.selectables

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

@Composable
fun RadioMinimalExample() {
    val selectedStates = remember { mutableStateListOf(false, false, false) }
    selectedStates.forEachIndexed { index, _ ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Option ${index + 1}")
            RadioButton(
                selected = selectedStates[index],
                onClick = {
                    selectedStates[index] = !selectedStates[index]
                    selectedStates.forEachIndexed { i, _ ->
                        if (i != index) {
                            selectedStates[i] = false
                        }
                    }
                }
            )
        }
    }
}
