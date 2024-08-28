package pro.kotlinmultiplatform.spacex.presentation.screen

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.koin.compose.viewmodel.koinViewModel
import pro.kotlinmultiplatform.spacex.presentation.composable.LaunchListScreen
import pro.kotlinmultiplatform.spacex.presentation.model.Screen
import pro.kotlinmultiplatform.spacex.presentation.viewmodel.LaunchListViewModel

fun NavGraphBuilder.launchListScreen() {
    composable(
        route = Screen.LaunchList.route,
    ) {
        val viewModel = koinViewModel<LaunchListViewModel>()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        LaunchListScreen(
            uiState = uiState,
        )
    }
}