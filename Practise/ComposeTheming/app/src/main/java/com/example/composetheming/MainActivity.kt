package com.example.composetheming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetheming.dialogs.AlertDialogExample
import com.example.composetheming.lists_grids.ShowSimpleListWithLazyRow
import com.example.composetheming.lists_grids.ShowSimpleStaggeredGrid
import com.example.composetheming.lists_grids.ShowSimpleVerticalGrid
import com.example.composetheming.ui.theme.ComposeThemingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeThemingTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                   // ShowModalBottomSheet()
                   // PartialBottomSheet()
                    //ShowDrawer()
                   // ShowSnackbar()
                    //ShowSimpleListWithColumn()
                    //ShowSimpleListWithRow()
                   // ShowSimpleListWithLazyRow()
                   // ShowSimpleVerticalGrid()
                    ShowSimpleStaggeredGrid()
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeThemingTheme {
        AlertDialogExample(
            onConfirmation = {},
            onDismissRequest = {},
            dialogText = "Welcome to compose",
            dialogTitle = "Dialog Title",
            icon = Icons.Filled.Info
        )
    }
}


@Composable
private fun LogPointerEvents(filter: PointerEventType? = null) {
    var log by remember { mutableStateOf("") }
    Column {
        Text(log)
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Red)
                .pointerInput(filter) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            log = "${event.type}, ${event.changes.first().position}"
                        }
                    }
                }
        )
    }
}

@Composable
fun SelectComponents() {
    // Checkbox(checked = true, onCheckedChange = null)

    MaterialTheme {
        var checked by remember { mutableStateOf(false) }
        Row(
            Modifier
                .toggleable(
                    value = checked,
                    role = Role.Checkbox,
                    onValueChange = { checked = !checked }
                )
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("Option", modifier = Modifier.weight(1f))
            Checkbox(checked = checked, onCheckedChange = null)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasQuadrantSize = size / 2F
        drawRect(
            color = Color.Magenta,
            size = canvasQuadrantSize
        )

        val canvasWidth = size.width / 2
        val canvasHeight = size.height / 2
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            color = Color.Blue
        )

        scale(scaleX = 10f, scaleY = 15f) {
            drawCircle(Color.Blue, radius = 10.dp.toPx())
        }

        translate(left = 60f, top = -800f) {
            drawCircle(Color.Blue, radius = 50.dp.toPx())
        }

        rotate(degrees = 45F) {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = size.width / 2F, y = size.height / 2F),
                size = size / 5F
            )
        }
    }


}

@Composable
fun Greeting1() {
    Text(
        "Hello Compose!",
        modifier = Modifier
            .drawBehind {
                drawRoundRect(
                    Color(0xFFBBAAEE),
                    cornerRadius = CornerRadius(10.dp.toPx())
                )
            }
            .padding(4.dp)
    )
}
