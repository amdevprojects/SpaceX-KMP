package pro.kotlinmultiplatform.spacex.data.repository

import pro.kotlinmultiplatform.spacex.data.entity.RocketLaunch

interface LaunchRepository {

    suspend fun getLaunchList(forceReload: Boolean = false): List<RocketLaunch>
}