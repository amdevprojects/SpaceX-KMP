package pro.kotlinmultiplatform.spacex.presentation.model

sealed class Screen(val route: String) {

    companion object {
        const val ROUTE_LAUNCH_LIST = "launch_list"
    }

    data object LaunchList : Screen(ROUTE_LAUNCH_LIST)
}