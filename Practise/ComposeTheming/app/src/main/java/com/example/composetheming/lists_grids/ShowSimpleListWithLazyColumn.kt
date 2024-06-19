package com.example.composetheming.lists_grids

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShowSimpleListWithLazyColumn() {
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
    LazyColumn {
        item{
            Text(text = "List: Starts Here")
        }
        items(names.size) { index ->
            Text(text = "Item: ${names[index]}")
        }
        item{
            Text(text = "List: Ends Here")
        }
    }
}

@Preview(name = "ShowDividers")
@Composable
private fun PreviewShowDividers() {
    ShowSimpleListWithLazyColumn()
}
