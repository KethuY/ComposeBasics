package com.example.sampleapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
/**
 * Created by Kethu on 12/06/2024.
 */
@Composable
fun ListScreen(
    onBack: () -> Unit,
) {
    Scaffold(topBar = {
        CustomToolbar(
            onBack = onBack, title = "Select the beneficiary", imageVector = Icons.Filled.ArrowBack
        )
    }) {
        Column() {
            Button(
                onClick = { }, modifier = Modifier.padding(it)
            ) {
                Text(text = "Visa Direct")
            }
        }
    }
}