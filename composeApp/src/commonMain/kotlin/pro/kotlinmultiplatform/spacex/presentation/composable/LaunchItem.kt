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
import org.jetbrains.compose.resources.stringResource
import pro.kotlinmultiplatform.spacex.presentation.state.LaunchItem
import pro.kotlinmultiplatform.spacex.presentation.theme.Spacing
import spacex.composeapp.generated.resources.Res
import spacex.composeapp.generated.resources.placeholder_desc_not_available

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
                .padding(Spacing.Default),
            verticalArrangement = Arrangement.spacedBy(Spacing.ExtraSmall)
        ) {
            Text(
                text = item.missionName,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = item.details ?: stringResource(Res.string.placeholder_desc_not_available),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}