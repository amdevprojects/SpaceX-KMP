package pro.kotlinmultiplatform.spacex.infra.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import pro.kotlinmultiplatform.spacex.data.entity.RocketLaunch

class SpaceXApi(private val client: HttpClient) {

    suspend fun getAllLaunches(): List<RocketLaunch> {
        return client.get("https://api.spacexdata.com/v5/launches").body()
    }
}