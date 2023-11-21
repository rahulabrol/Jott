package com.rahul.jott.dsm.material.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.theme.AppTheme

internal object AppCardDefaults {
    private const val DEFAULT_ELEVATION = 1

    /**
     * The default shape radius for a search field
     */
    val Shape: Shape
        @Composable
        get() = AppTheme.shapes.medium

    /**
     * The default elevation for a search field
     */
    val Elevation: Dp
        @Composable
        get() = DEFAULT_ELEVATION.dp

    /**
     * The default color for a search field
     */
    val BackgroundColor: Color
        @Composable
        get() = AppTheme.colors.surface

    /**
     * The default color for a search field
     */
    val ContentColor: Color
        @Composable
        get() = AppTheme.colors.onSurfaceHighEmphasis
}
