package com.rahul.jott.dsm.material.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.rahul.jott.dsm.theme.AppTheme

internal object AppScaffoldDefaults {
    const val IsFloatingActionButtonDocked: Boolean = false

    val BackgroundColor: Color
        @Composable
        get() = AppTheme.colors.background

    val ContentColor: Color
        @Composable
        get() = AppTheme.colors.onBackgroundHighEmphasis
}
