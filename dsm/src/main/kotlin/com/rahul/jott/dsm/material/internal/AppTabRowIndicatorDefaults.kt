package com.rahul.jott.dsm.material.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal object AppTabRowIndicatorDefaults {
    private const val DEFAULT_INDICATOR_VERTICAL_PADDING = 0
    private const val DEFAULT_INDICATOR_HORIZONTAL_PADDING = 32
    private const val DEFAULT_INDICATOR_HORIZONTAL_Height = 2

    /**
     * Vertical default padding for the tab indicator
     */
    val IndicatorVerticalPadding: Dp
        @Composable
        get() = DEFAULT_INDICATOR_VERTICAL_PADDING.dp

    /**
     * Horizontal default padding for the tab indicator
     * */
    val IndicatorHorizontalPadding: Dp
        @Composable
        get() = DEFAULT_INDICATOR_HORIZONTAL_PADDING.dp

    /**
     * The default padding for the tab indidcator
     * */
    val IndicatorHeight: Dp
        @Composable
        get() = DEFAULT_INDICATOR_HORIZONTAL_Height.dp
}
