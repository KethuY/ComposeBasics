package com.example.composetheming.dividers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShowDividers(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text("First item in list")
        Divider(thickness = 2.dp)
        Text("Second item in list")
    }

    Row(Modifier
        .height(IntrinsicSize.Min) //intrinsic measurements
        .fillMaxWidth()
    ) {
        Text("First")
        Divider(
            color = Color.Red,
            modifier = Modifier
                .fillMaxHeight()  //fill the max height
                .width(1.dp)
        )
        Text("Second")
    }
}

@Preview(name = "ShowDividers")
@Composable
private fun PreviewShowDividers() {
    ShowDividers()
}
