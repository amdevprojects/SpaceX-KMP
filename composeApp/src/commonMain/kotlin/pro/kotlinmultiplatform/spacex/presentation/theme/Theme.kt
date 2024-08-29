package pro.kotlinmultiplatform.spacex.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import spacex.composeapp.generated.resources.Res
import spacex.composeapp.generated.resources.lato_regular

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        isSystemInDarkTheme() -> DarkColorScheme
        else -> LightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = typography(fontFamily = fontFamily),
        content = content
    )
}

private val fontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(Res.font.lato_regular, weight = FontWeight.Normal)
    )