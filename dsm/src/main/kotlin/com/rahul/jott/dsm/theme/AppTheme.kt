package com.rahul.jott.dsm.theme

import androidx.compose.runtime.Composable
import com.rahul.jott.dsm.theme.internal.LocalAppColorsProvider
import com.rahul.jott.dsm.theme.internal.LocalAppShapesProvider
import com.rahul.jott.dsm.theme.internal.LocalAppTypographyProvider

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColorsProvider.current
    val typography: AppTypography
        @Composable
        get() = LocalAppTypographyProvider.current
    val shapes: AppShapes
        @Composable
        get() = LocalAppShapesProvider.current
}
