package com.example.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampleapp.ui.theme.Pink40
import com.example.sampleapp.ui.theme.SampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAppTheme {
                ArtistCardView()
                /* Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                     CustomNavHost(modifier = Modifier.padding(innerPadding))
                 }*/
            }
        }
    }
}


@Composable
fun Artist() {
    Row(
        modifier = Modifier
            .background(color = Pink40)
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "Artist image",
            modifier = Modifier.requiredSize(48.dp)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text("Alfred Sisley", color = Color.White, style = MaterialTheme.typography.titleMedium)
            Text("3 minutes ago", color = Color.White)
        }
    }
}

@Composable
fun ArtistCardView() {
    val padding = 16.dp
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()
    )
    {
        Artist()
        Spacer(modifier = Modifier.size(padding))
        Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue))
        }
    }
}

@Composable
fun ArtistCardView1() {
    Box {
        Spacer(
            Modifier
                .matchParentSize()
                .background(Color.Red)
        )

        Artist()
    }
}


@Preview
@Composable
fun Preview() {
    ImageViewEx()
}

@Composable
fun ImageViewEx() {
    Image(
        painterResource(R.drawable.ic_launcher_background),
        contentDescription = null,
          Modifier.fillMaxSize().wrapContentSize().clip(CircleShape).padding(16.dp).size(100.dp)

      //  Modifier.sizeIn(minWidth = 100.dp, minHeight = 100.dp)
    )
}



