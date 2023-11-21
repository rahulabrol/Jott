package com.rahul.jott.dsm.material.internal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.rahul.jott.dsm.theme.AppTheme

/**
 * App column defaults
 *
 * @constructor Create empty App column defaults
 */
object AppColumnDefaults {
    /**
     * The default color for a search field
     */
    val BackgroundColor: Color
        @Composable
        get() = AppTheme.colors.surface

    /**
     * Vertical alignment
     */
    val verticalAlignment: Arrangement.Vertical
        @Composable
        get() = Arrangement.Top

    /**
     * Horizontal alignment
     */
    val horizontalAlignment: Alignment.Horizontal
        @Composable
        get() = Alignment.Start
}
