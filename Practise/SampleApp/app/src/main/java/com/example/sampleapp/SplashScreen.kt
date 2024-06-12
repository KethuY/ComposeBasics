package com.example.sampleapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sampleapp.ui.theme.Purple40

/**
 * Created by Kethu on 11/06/2024.
 */
@Composable
fun SplashScreen(onButtonClickListener: () -> Unit) {
    Scaffold() { it ->
        Column(
            modifier = Modifier
                .background(color = Purple40)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { onButtonClickListener.invoke() }, modifier = Modifier.padding(it)
            ) {
                Text(text = "Click Me")
            }
        }
    }
}