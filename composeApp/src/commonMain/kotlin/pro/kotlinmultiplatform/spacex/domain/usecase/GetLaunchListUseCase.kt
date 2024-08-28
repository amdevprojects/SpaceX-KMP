package pro.kotlinmultiplatform.spacex.domain.usecase

import pro.kotlinmultiplatform.spacex.data.repository.LaunchRepository
import pro.kotlinmultiplatform.spacex.domain.model.RocketLaunch
import pro.kotlinmultiplatform.spacex.domain.model.toDomainModel

class GetLaunchListUseCase(private val repository: LaunchRepository) {

    suspend fun execute(): List<RocketLaunch> = repository.getLaunchList().map { it.toDomainModel() }
}