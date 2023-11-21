package com.rahul.jott.dsm.material.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.theme.AppTheme

object AppDividerDefaults {
    private const val DEFAULT_THICKNESS = 1
    private const val DEFAULT_START_INDENT = 0

    val Color: Color
        @Composable get() = AppTheme.colors.outlineHighEmphasis

    val Thickness: Dp
        @Composable get() = DEFAULT_THICKNESS.dp

    val StartIndent: Dp
        @Composable get() = DEFAULT_START_INDENT.dp
}
