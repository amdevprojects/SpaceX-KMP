package pro.kotlinmultiplatform.spacex

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import pro.kotlinmultiplatform.spacex.infra.di.commonModule
import pro.kotlinmultiplatform.spacex.infra.di.dbModule

class SpaceXApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SpaceXApp)
            modules(
                listOf(
                    dbModule,
                    commonModule,
                )
            )
        }
    }
}