package pro.kotlinmultiplatform.spacex.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pro.kotlinmultiplatform.spacex.presentation.state.LaunchListUiState

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
                        text = "SpaceX Launches",
                    )
                },
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(
                items = uiState.launchList,
                key = { item -> item.flightNumber },
            ) { item ->
                LaunchItem(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    item = item,
                )
            }
        }
    }
}