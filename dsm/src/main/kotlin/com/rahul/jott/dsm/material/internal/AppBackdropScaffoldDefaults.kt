package com.rahul.jott.dsm.material.internal

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.rahul.jott.dsm.theme.AppTheme

internal object AppBackdropScaffoldDefaults {
    val FrontLayerBackgroundColor: Color
        @Composable
        get() = AppTheme.colors.background

    val FrontLayerContentColor: Color
        @Composable
        get() = AppTheme.colors.onBackgroundHighEmphasis

    val BackLayerBackgroundColor: Color
        @Composable
        get() = AppTheme.colors.backgroundSecondary

    val BackLayerContentColor: Color
        @Composable
        get() = AppTheme.colors.onBackgroundMediumEmphasis

    val FrontLayerShape: CornerBasedShape
        @Composable
        get() = AppTheme.shapes.zero
}
