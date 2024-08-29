package pro.kotlinmultiplatform.spacex.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.stringResource
import pro.kotlinmultiplatform.spacex.presentation.state.LaunchListUiState
import pro.kotlinmultiplatform.spacex.presentation.theme.Spacing
import spacex.composeapp.generated.resources.Res
import spacex.composeapp.generated.resources.title_launch_list_screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaunchListScreen(
    uiState: LaunchListUiState,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(Res.string.title_launch_list_screen),
                    )
                },
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Spacing.ExtraSmall),
        ) {
            items(
                items = uiState.launchList,
                key = { item -> item.flightNumber },
            ) { item ->
                LaunchItem(
                    modifier = Modifier
                        .padding(horizontal = Spacing.Default),
                    item = item,
                )
            }
        }
    }
}