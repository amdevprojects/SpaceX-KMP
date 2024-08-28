package pro.kotlinmultiplatform.spacex.infra.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pro.kotlinmultiplatform.spacex.infra.db.DatabaseDriverFactory

val dbModule = module {
    single<DatabaseDriverFactory> { DatabaseDriverFactory(androidContext()) }
}