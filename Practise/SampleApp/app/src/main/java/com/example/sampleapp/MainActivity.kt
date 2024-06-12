package com.example.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ContextualFlowRowOverflowScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleapp.ui.theme.SampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAppTheme {
                Scaffold {
                    FlowColumnExample()
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowColumnExample() {
    FlowColumn(
        Modifier
            .padding(20.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        maxItemsInEachColumn = 3,
    ) {
        repeat(10) {
            Box(
                Modifier
                    .fillMaxColumnWidth()
                    .border(1.dp, Color.DarkGray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {
                Text(
                    text = listOf("Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8", "Item9", "Item10")[it],
                    fontSize = 18.sp,
                    modifier = Modifier.padding(3.dp)
                )
            }
        }
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GridFlow(){
    Column {
        val rows = 3
        val columns = 3
        FlowRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = rows
        ) {
            val itemModifier = Modifier
                .padding(4.dp)
                .height(80.dp)
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Blue)
            repeat(rows * columns) {
                Spacer(modifier = itemModifier)
            }
        }

        FlowRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = 2
        ) {
            val itemModifier = Modifier
                .padding(4.dp)
                .height(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Blue)
            repeat(6) { item ->
                // if the item is the third item, don't use weight modifier, but rather fillMaxWidth
                if ((item + 1) % 3 == 0) {
                    Spacer(modifier = itemModifier.fillMaxWidth())
                } else {
                    Spacer(modifier = itemModifier.weight(0.5f))
                }
            }
        }

        FlowRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = 3
        ) {
            val itemModifier = Modifier
                .clip(RoundedCornerShape(8.dp))
            Box(modifier = itemModifier.height(200.dp).width(60.dp).background(Color.Red))
            Box(modifier = itemModifier.height(200.dp).fillMaxWidth(0.7f).background(Color.Blue))
            Box(modifier = itemModifier.height(200.dp).weight(1f).background(Color.Magenta))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContextFlowEx() {
    val totalCount = 40
    var maxLines by remember { mutableStateOf(5) }

    val moreOrCollapseIndicator = @Composable { scope: ContextualFlowRowOverflowScope ->
        val remainingItems = totalCount - scope.shownItemCount
        ChipItem(if (remainingItems == 0) "Less" else "+$remainingItems", onClick = {
            if (remainingItems == 0) {
                maxLines = 2
            } else {
                maxLines += 5
            }
        })
    }
    ContextualFlowRow(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxWidth(1f)
            .padding(16.dp)
            .wrapContentHeight(align = Alignment.Top)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        maxLines = maxLines,
        overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
            minRowsToShowCollapse = 4,
            expandIndicator = moreOrCollapseIndicator,
            collapseIndicator = moreOrCollapseIndicator
        ),
        itemCount = totalCount
    ) { index ->
        ChipItem("Item $index")
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FlowRowSimpleUsageExample() {
    FlowRow(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        ChipItem("Price: High to Low")
        ChipItem("Avg rating: 4+")
        ChipItem("Free breakfast")
        ChipItem("Free cancellation")
        ChipItem("£50 pn")
        ChipItem("Price: High to Low")
        ChipItem("Avg rating: 4+")
        ChipItem("Free breakfast")
        ChipItem("Free cancellation")
        ChipItem("£50 pn")
    }

}

@Composable
fun ChipItem(text: String, onClick: (() -> Unit)? = null) {
    Card(
        modifier = Modifier.padding(end = 4.dp),
        border = BorderStroke(1.dp, Color(0xFF3B3A3C))
    ) {
        Text(text, modifier = Modifier.padding(8.dp))
    }
}



