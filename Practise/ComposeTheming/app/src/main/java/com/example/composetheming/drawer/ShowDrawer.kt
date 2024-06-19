package com.example.composetheming.drawer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetheming.appbar.ScaffoldExample
import kotlinx.coroutines.launch

@Composable
fun ShowDrawer(
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Coffee") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Milk") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Sugar") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                // ...other drawer items
            }

        }
    ) {
        ScaffoldExample(showDrawer = {
            scope.launch {
                drawerState.close()
            }
        }, onContinueClicked = {
            scope.launch {
                drawerState.open()
            }
        })
    }

}

@Preview(name = "ShowDrawer")
@Composable
private fun PreviewShowDrawer() {
    ShowDrawer()
}