package com.example.sampleapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sampleapp.ui.theme.SampleAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAppTheme {
                Scaffold {
                    Card("Title","Description")
                }
            }
        }
    }
    @Composable
    fun Card(
        title: String,
        description: String
    ) {
        BoxWithConstraints {
            if (maxWidth < 400.dp) {
                Column {
                    Image(painterResource(id = R.drawable.ic_launcher_background),contentDescription = null)
                    Text(title)
                }
            } else {
                Row {
                    Column {
                        Text(title)
                        Text(description)
                    }
                    Image(painterResource(id = R.drawable.ic_launcher_background),contentDescription = null)
                }
            }
        }
    }
}
