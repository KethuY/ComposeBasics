package com.example.sampleapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * Created by Kethu on 11/06/2024.
 */
@Composable
fun CustomNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Splash = Splash
) {
    //  val currentNavBackStackEntry by navController.currentBackStackEntryAsState()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<Splash> {
            SplashScreen() {
                navController.navigate(Landing)
            }
        }

        composable<Landing> {
            ListScreen(onBack = { navController.popBackStack() })
        }
    }
}