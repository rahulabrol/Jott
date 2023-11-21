package com.rahul.jott.dsm.material.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.rahul.jott.dsm.theme.AppTheme

internal object AppTextDefaults {
    val defaultTextColor: Color
        @Composable
        get() = AppTheme.colors.textColor

    val onSurfaceHighEmphasis: Color
        @Composable
        get() = AppTheme.colors.onSurfaceHighEmphasis

    val onPrimaryHighEmphasis: Color
        @Composable
        get() = AppTheme.colors.onPrimaryHighEmphasis
}
