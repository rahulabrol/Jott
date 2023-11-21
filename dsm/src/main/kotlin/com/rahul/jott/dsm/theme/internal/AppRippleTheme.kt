package com.rahul.jott.dsm.theme.internal

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.rahul.jott.dsm.theme.AppTheme

internal object AppRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = AppTheme.colors.primary

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        Color.Black,
        lightTheme = !isSystemInDarkTheme()
    )
}
