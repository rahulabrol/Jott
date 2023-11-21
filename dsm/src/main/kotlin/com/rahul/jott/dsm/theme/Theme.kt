package com.rahul.jott.dsm.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.rahul.jott.dsm.theme.internal.AppDarkColors
import com.rahul.jott.dsm.theme.internal.AppMainDarkColors
import com.rahul.jott.dsm.theme.internal.AppMainLightColors
import com.rahul.jott.dsm.theme.internal.AppRippleTheme
import com.rahul.jott.dsm.theme.internal.AppTextStyle
import com.rahul.jott.dsm.theme.internal.LocalAppColorsProvider
import com.rahul.jott.dsm.theme.internal.LocalAppShapesProvider
import com.rahul.jott.dsm.theme.internal.LocalAppTypographyProvider
import com.rahul.jott.dsm.theme.internal.Shapes
import com.rahul.jott.dsm.theme.internal.Typography

/**
 * @param darkTheme
 * @param content
 */
@Composable
fun JottTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
    val colors = if (darkTheme) AppMainDarkColors else AppMainLightColors
    SystemUiColor(color = colors.surface)

    AppTheme(
        colors = colors, content = content
    )
}

/**
 * @param content
 */
@Composable
fun AppDarkTheme(
    content: @Composable () -> Unit
) {
    AppTheme(
        colors = AppDarkColors,
        content = content
    )
}

/**
 * @param darkTheme
 * @param content
 */
@Composable
fun AppPrimaryStatusBarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
    val colors = if (darkTheme) AppMainDarkColors else AppMainLightColors
    JottTheme(
        content = content
    )
    StatusBarColor(color = colors.primary)
}

/**
 * A composable function to set the global material theme in Compose.
 *
 * @param content the composable function to display Composable content on the screen
 * @return A Compose material theme
 */
@Composable
private fun AppTheme(
    colors: AppColors, content: @Composable () -> Unit
) {
    val appRippleIndication = rememberRipple(color = colors.primary)

    CompositionLocalProvider(
        LocalAppColorsProvider provides colors,
        LocalAppTypographyProvider provides Typography,
        LocalAppShapesProvider provides Shapes,
        LocalRippleTheme provides AppRippleTheme,
        LocalIndication provides appRippleIndication
    ) {
        MaterialTheme {
            ProvideTextStyle(
                value = AppTextStyle.Default, content = content
            )
        }
    }
}

@Composable
private fun SystemUiColor(color: Color) {
    val sysUiController = rememberSystemUiController()

    SideEffect {
        sysUiController.setSystemBarsColor(
            color = color
        )
    }
}

@Composable
private fun StatusBarColor(color: Color) {
    val sysUiController = rememberSystemUiController()

    SideEffect {
        sysUiController.setStatusBarColor(
            color = color
        )
    }
}