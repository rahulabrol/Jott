package com.rahul.jott.dsm.component.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.theme.AppTheme

object AppRecentSearchCardDefaults {
    private const val DEFAULT_ELEVATION = 4

    val BackgroundColor: Color
        @Composable
        get() = AppTheme.colors.surface

    val Elevation: Dp
        @Composable
        get() = DEFAULT_ELEVATION.dp

    val Shape: Shape
        @Composable
        get() = AppTheme.shapes.medium
}
