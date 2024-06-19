package com.example.composetheming.lists_grids

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetheming.R

@Composable
fun ShowSimpleVerticalGrid() {
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
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 32.dp)
    ) {
        items(names.size) { _ ->
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
        }
    }
}

@Preview(name = "ShowDividers")
@Composable
private fun PreviewShowDividers() {
    ShowSimpleVerticalGrid()
}
