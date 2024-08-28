package pro.kotlinmultiplatform.spacex.presentation.composable

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import pro.kotlinmultiplatform.spacex.presentation.model.Screen
import pro.kotlinmultiplatform.spacex.presentation.screen.launchListScreen

@Composable
fun AppNavHost() {
    NavHost(
        navController = rememberNavController(),
        startDestination = Screen.LaunchList.route,
    ) {
        launchListScreen()
    }
}