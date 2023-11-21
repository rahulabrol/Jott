package com.rahul.jott.dsm.material.internal

import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.theme.AppTheme

internal object AppSurfaceDefaults {
    private const val DEFAULT_ELEVATION = 0

    /**
     * The default shape radius for a search field
     */
    val Shape: Shape
        @Composable
        get() = RectangleShape

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
        get() = AppTheme.colors.primary

    /**
     * The default color for a search field
     */
    val Indication: Indication
        @Composable
        get() = LocalIndication.current
}
