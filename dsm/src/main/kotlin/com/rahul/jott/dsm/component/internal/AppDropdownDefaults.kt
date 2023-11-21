package com.rahul.jott.dsm.component.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.theme.AppTheme

object AppDropdownDefaults {
    private const val DEFAULT_WIDTH = 171
    private const val DEFAULT_HEIGHT = 292f
    private const val DEFAULT_OFFSET_X = 0
    private const val DEFAULT_OFFSET_Y = 0

    val width: Dp
        @Composable
        get() = DEFAULT_WIDTH.dp

    val height: Dp
        @Composable
        get() = DEFAULT_HEIGHT.dp

    val offsetX: Dp
        @Composable
        get() = DEFAULT_OFFSET_X.dp

    val offsetY: Dp
        @Composable
        get() = DEFAULT_OFFSET_Y.dp

    val backgroundColor: Color
        @Composable
        get() = AppTheme.colors.background

    val textStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body1

    val textColor: Color
        @Composable
        get() = AppTheme.colors.textColor
}
