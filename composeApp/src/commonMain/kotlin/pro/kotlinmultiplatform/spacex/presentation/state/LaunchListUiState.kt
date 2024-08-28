package pro.kotlinmultiplatform.spacex.presentation.state

data class LaunchListUiState(
    val screenState: ScreenState = ScreenState.Loading,
    val launchList: List<LaunchItem> = emptyList(),
)

data class LaunchItem(
    val flightNumber: Int,
    val missionName: String,
    val details: String?,
    val launchSuccess: Boolean?,
)

fun pro.kotlinmultiplatform.spacex.domain.model.RocketLaunch.toUiModel(): LaunchItem = LaunchItem(
    flightNumber = flightNumber,
    missionName = missionName,
    details = details,
    launchSuccess = launchSuccess,
)

