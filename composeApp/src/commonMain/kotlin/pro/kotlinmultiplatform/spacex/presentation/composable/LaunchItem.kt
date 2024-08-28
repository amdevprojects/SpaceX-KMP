package pro.kotlinmultiplatform.spacex.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pro.kotlinmultiplatform.spacex.presentation.state.LaunchItem

@Composable
fun LaunchItem(
    modifier: Modifier = Modifier,
    item: LaunchItem,
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = item.missionName,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = item.details ?: "Description not available..",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}