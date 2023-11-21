package com.rahul.jott.dsm.component.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.material.IconDefaults
import com.rahul.jott.dsm.theme.AppTheme

object BannerDefaults {
    private const val DEFAULT_ELEVATION = 4
    val Elevation: Dp
        @Composable
        get() = DEFAULT_ELEVATION.dp

    val Shape: Shape
        @Composable
        get() = AppTheme.shapes.medium

    val CircleBgColor: Color
        @Composable
        get() = AppTheme.colors.onPrimaryMediumEmphasis

    val CircleBgSize: Dp
        @Composable
        get() = IconDefaults.IconBackgroundSize

    val IconLabelColor: Color
        @Composable
        get() = AppTheme.colors.textColor

    val IconLabelStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body2
}
