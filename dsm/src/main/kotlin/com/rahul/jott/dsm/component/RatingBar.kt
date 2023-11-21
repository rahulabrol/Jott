package com.rahul.jott.dsm.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder
import com.rahul.jott.dsm.R
import com.rahul.jott.dsm.theme.AppTheme
import kotlin.math.floor

private fun Double.parts(): Pair<Int, Double> {
    val floorVal = floor(this)
    return Pair(floorVal.toInt(), this - floorVal)
}

/**
 * @param modifier
 * @param rating
 */
@Composable
fun StarRatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.5,
    iconTint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    loading: Boolean = false
) {
    if (rating < 0 || rating > 5) {
        throw IllegalArgumentException()
    }
    val (num, dec) = rating.parts()
    Row(
        modifier = modifier
            .padding(bottom = 4.dp)
            .placeholder(
                visible = loading,
                highlight = PlaceholderHighlight.shimmer(),
                color = AppTheme.colors.background,
                shape = AppTheme.shapes.small
            ),
    ) {
        for (i in 0 until num) {
            FullStarIcon(iconTint)
        }
        if (dec > 0) {
            HalfStarIcon(iconTint)
        }
    }
}

@Composable
private fun FullStarIcon(iconTint: Color) {
    Icon(
        modifier = Modifier.size(16.dp),
        painter = painterResource(id = R.drawable.ic_splash_screen),
        tint = iconTint,
        contentDescription = null
    )
}

@Composable
private fun HalfStarIcon(iconTint: Color) {
    Icon(
        modifier = Modifier.size(16.dp),
        painter = painterResource(id = R.drawable.ic_splash_screen),
        tint = iconTint,
        contentDescription = null
    )
}
