package com.rahul.jott.dsm.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.rahul.jott.dsm.material.internal.AppColumnDefaults

/**
 * App column
 *
 * @param modifier
 * @param backgroundColor
 * @param verticalArrangement
 * @param horizontalAlignment
 * @param content
 */
@Composable
fun AppColumn(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppColumnDefaults.BackgroundColor,
    verticalArrangement: Arrangement.Vertical = AppColumnDefaults.verticalAlignment,
    horizontalAlignment: Alignment.Horizontal = AppColumnDefaults.horizontalAlignment,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier.background(backgroundColor),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}
