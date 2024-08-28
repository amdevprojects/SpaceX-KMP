package pro.kotlinmultiplatform.spacex.infra.di

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import pro.kotlinmultiplatform.spacex.data.repository.LaunchRepository
import pro.kotlinmultiplatform.spacex.data.repository.impl.LaunchRepositoryImpl
import pro.kotlinmultiplatform.spacex.domain.usecase.GetLaunchListUseCase
import pro.kotlinmultiplatform.spacex.infra.db.Database
import pro.kotlinmultiplatform.spacex.infra.network.SpaceXApi
import pro.kotlinmultiplatform.spacex.presentation.viewmodel.LaunchListViewModel

val commonModule = module {
    viewModel { LaunchListViewModel(get()) }

    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }
        }
    }
    single<LaunchRepository> { LaunchRepositoryImpl(get(), get()) }

    factory<SpaceXApi> { SpaceXApi(get()) }
    factory<Database> { Database(get()) }
    factory { GetLaunchListUseCase(get()) }
}