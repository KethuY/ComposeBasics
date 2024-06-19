package com.example.composetheming.lists_grids

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShowSimpleListWithColumn() {
    val names = listOf(
        "Satya",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev",
        "Srinu",
        "Rajeev",
        "Satya",
        "Srinu",
        "Rajeev"
    )

    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        names.forEach { message ->
            MessageRow(message)
        }
    }
}

@Composable
fun MessageRow(message: String) {
    Text(text = message)
}

@Preview(name = "ShowDividers")
@Composable
private fun PreviewShowDividers() {
    ShowSimpleListWithColumn()
}
