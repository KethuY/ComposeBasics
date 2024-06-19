package com.example.composetheming.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun ShowDifferentButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Simple button")
        }
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Filled tonal button")
        }
        ElevatedButton(onClick = { /*TODO*/ }) {
            Text(text = "Elevated tonal button")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Outlined  button")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "text  button")
        }

        FloatingActionButton(
            onClick = { },
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }

        SmallFloatingActionButton(
            onClick = { },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Filled.Add, "Small floating action button.")
        }

        LargeFloatingActionButton(
            onClick = { },
            shape = RectangleShape,
        ) {
            Icon(Icons.Filled.Add, "Large floating action button")
        }

        ExtendedFloatingActionButton(
            onClick = { },
            icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
            text = { Text(text = "Extended FAB") },
        )
    }
}