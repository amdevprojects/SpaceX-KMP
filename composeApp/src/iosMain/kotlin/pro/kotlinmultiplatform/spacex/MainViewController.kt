package pro.kotlinmultiplatform.spacex

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.context.startKoin
import pro.kotlinmultiplatform.spacex.infra.di.commonModule
import pro.kotlinmultiplatform.spacex.infra.di.dbModule

fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
            modules(
                listOf(
                    dbModule,
                    commonModule,
                )
            )
        }
    }
) { App() }