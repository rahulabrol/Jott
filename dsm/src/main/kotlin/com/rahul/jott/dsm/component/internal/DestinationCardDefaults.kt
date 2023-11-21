package com.rahul.jott.dsm.component.internal

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal object DestinationCardDefaults {
    private const val DEFAULT_HEIGHT = 180
    private const val DEFAULT_ELEVATION = 4
    private const val DEFAULT_ROUNDED_CORNERS = 16

    /**
     * The default height for a search field
     */
    val Height: Dp
        @Composable
        get() = DEFAULT_HEIGHT.dp

    /**
     * The default elevation for a search field
     */
    val Elevation: Dp
        @Composable
        get() = DEFAULT_ELEVATION.dp

    val Shape: Shape
        @Composable
        get() = RoundedCornerShape(DEFAULT_ROUNDED_CORNERS.dp)
}
