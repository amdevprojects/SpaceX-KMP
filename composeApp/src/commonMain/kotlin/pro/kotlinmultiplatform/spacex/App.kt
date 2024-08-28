package pro.kotlinmultiplatform.spacex

import androidx.compose.runtime.Composable
import org.koin.compose.KoinContext
import pro.kotlinmultiplatform.spacex.presentation.composable.AppNavHost
import pro.kotlinmultiplatform.spacex.presentation.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        KoinContext {
            AppNavHost()
        }
    }
}