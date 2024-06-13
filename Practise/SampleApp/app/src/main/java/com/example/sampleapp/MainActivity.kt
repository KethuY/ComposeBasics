package com.example.sampleapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
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
                    CustomLayout()
                }
            }
        }
    }

    @Composable
    private fun CustomLayout() {

        MyBasicColumn(Modifier.padding(8.dp)) {
            Text("Hi there!", Modifier.firstBaselineToTop(200.dp))
            Text("MyBasicColumn")
            Text("places items")
            Text("vertically.")
            Text("We've done it by hand!")
        }
    }


    private fun Modifier.firstBaselineToTop(
        firstBaselineToTop: Dp
    ) = layout { measurable, constraints ->
        // Measure the composable
        val placeable = measurable.measure(constraints)

        // Check the composable has a first baseline
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]

        // Height of the composable with padding - first baseline
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            // Where the composable gets placed
            placeable.placeRelative(0, placeableY)
        }
    }

    @Composable
    fun MyBasicColumn(
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Layout(
            modifier = modifier,
            content = content
        ) { measurables, constraints ->
            // Don't constrain child views further, measure them with given constraints
            // List of measured children
            val placeables = measurables.map { measurable ->
                // Measure each children
                measurable.measure(constraints)
            }

            // Set the size of the layout as big as it can
            layout(constraints.maxWidth, constraints.maxHeight) {
                // Track the y co-ord we have placed children up to
                var xPosition = 0

                // Place children in the parent layout
                placeables.forEach { placeable ->
                    // Position item on the screen
                    placeable.placeRelative(x = xPosition, y = 0)

                    // Record the y co-ord placed up to
                    xPosition += placeable.width
                }
            }
        }
    }

}
