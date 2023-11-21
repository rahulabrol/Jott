package com.rahul.jott.dsm.material.internal

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.theme.AppTheme

internal object AppSnackbarDefaults {
    private const val DEFAULT_ELEVATION = 6
    private const val DEFAULT_PADDING = 12
    const val ActionOnNewLine: Boolean = false

    /**
     * Default elevation to apply to this [AppSnackbar]
     */
    val Elevation = DEFAULT_ELEVATION.dp

    /**
     * Default padding to apply to this [AppSnackbar]
     */
    val Padding = DEFAULT_PADDING.dp

    /**
     * Default shape to apply to this [AppSnackbar]
     */
    val Shape: Shape
        @Composable
        get() = AppTheme.shapes.medium

    /**
     * Provides a best-effort 'primary' color to be used as the [AppTheme.colors.onPrimary] color inside a [AppSnackbar].
     * Given that [AppSnackbar]s have an 'inverted' theme, i.e. in a light theme they appear dark, and
     * in a dark theme they appear light, just using [Colors.onPrimary] will not work, and has
     * incorrect contrast.
     *
     * If your light theme has a corresponding dark theme, you should instead directly use
     * [Colors.onPrimary] from the dark theme when in a light theme, and use
     * [Colors.primaryVariant] from the dark theme when in a dark theme.
     *
     * When in a light theme, this function applies a color overlay to [Colors.onPrimary] from
     * [AppTheme.colors] to attempt to reduce the contrast, and when in a dark theme this
     * function uses [AppTheme.colors.primaryVariant].
     */
    val PrimaryActionColor: Color
        @Composable
        get() {
            val colors = AppTheme.colors
            return if (!isSystemInDarkTheme()) {
                colors.primary
            } else {
                colors.primaryVariant
            }
        }

    /**
     * The default background color of the [AppSnackbar]
     */
    val BackgroundColor: Color
        @Composable
        get() = AppTheme.colors.background
}
