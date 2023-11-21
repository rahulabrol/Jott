package com.rahul.jott.dsm.material

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.rahul.jott.dsm.material.internal.AppProgressIndicatorDefaults
import com.rahul.jott.dsm.theme.AppTheme

/**
 * @param modifier
 * @param color
 * @param strokeWidth
 */
@Composable
fun AppCircularProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.primary,
    strokeWidth: Dp = AppProgressIndicatorDefaults.StrokeWidth
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = color,
        strokeWidth = strokeWidth
    )
}

/**
 * @param modifier
 * @param color
 * @param backgroundColor
 */
@Composable
fun AppLinearProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.primary,
    backgroundColor: Color = color.copy(alpha = AppProgressIndicatorDefaults.IndicatorBackgroundOpacity)
) {
    LinearProgressIndicator(
        modifier = modifier,
        color = color,
        backgroundColor = backgroundColor
    )
}
