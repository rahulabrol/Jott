package com.rahul.jott.dsm.material

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.rahul.jott.dsm.material.internal.AppDividerDefaults

/**
 * @param modifier
 * @param color
 * @param thickness
 * @param startIndent
 */
@Composable
fun AppDivider(
    modifier: Modifier = Modifier,
    color: Color = AppDividerDefaults.Color,
    thickness: Dp = AppDividerDefaults.Thickness,
    startIndent: Dp = AppDividerDefaults.StartIndent
) {
    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness,
        startIndent = startIndent
    )
}
