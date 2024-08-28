package pro.kotlinmultiplatform.spacex.domain.model

data class RocketLaunch(
    val flightNumber: Int,
    val missionName: String,
    val details: String?,
    val launchSuccess: Boolean?,
)

internal fun pro.kotlinmultiplatform.spacex.data.entity.RocketLaunch.toDomainModel() = RocketLaunch(
    flightNumber = flightNumber,
    missionName = missionName,
    details = details,
    launchSuccess = launchSuccess,
)