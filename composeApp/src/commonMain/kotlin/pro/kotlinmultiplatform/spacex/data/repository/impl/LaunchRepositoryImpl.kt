package pro.kotlinmultiplatform.spacex.data.repository.impl

import pro.kotlinmultiplatform.spacex.data.entity.RocketLaunch
import pro.kotlinmultiplatform.spacex.data.repository.LaunchRepository
import pro.kotlinmultiplatform.spacex.infra.db.Database
import pro.kotlinmultiplatform.spacex.infra.network.SpaceXApi

class LaunchRepositoryImpl(
    private val api: SpaceXApi,
    private val database: Database,
): LaunchRepository {

    override suspend fun getLaunchList(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearAndCreateLaunches(it)
            }
        }
    }
}