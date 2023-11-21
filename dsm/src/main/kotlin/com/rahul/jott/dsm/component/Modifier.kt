package com.rahul.jott.dsm.component

import androidx.annotation.FloatRange
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.math.pow

private const val GRADIENT_RANGE_BOTTOM_FLOAT = 0.0f
private const val GRADIENT_RANGE_TOP_FLOAT = 1.0f
private const val DEFAULT_DECAY = 1.0f
private const val DEFAULT_NUM_STOPS = 16

/**
 * Draws a vertical gradient scrim in the foreground.
 *
 * @param color The color of the gradient scrim.
 * @param startYPercentage The start y value, in percentage of the layout's height (0f to 1f)
 * @param endYPercentage The end y value, in percentage of the layout's height (0f to 1f)
 * @param decay The exponential decay to apply to the gradient. Defaults to `1.0f` which is
 * a linear gradient.
 * @param numStops The number of color stops to draw in the gradient. Higher numbers result in
 * the higher visual quality at the cost of draw performance. Defaults to `16`.
 * @return A modifier the will draw a gradient in the composable foreground
 */
fun Modifier.verticalForegroundGradientScrim(
    color: Color,
    @FloatRange(from = GRADIENT_RANGE_BOTTOM_FLOAT.toDouble(), to = GRADIENT_RANGE_TOP_FLOAT.toDouble())
    startYPercentage: Float = GRADIENT_RANGE_BOTTOM_FLOAT,
    @FloatRange(from = GRADIENT_RANGE_BOTTOM_FLOAT.toDouble(), to = GRADIENT_RANGE_TOP_FLOAT.toDouble())
    endYPercentage: Float = GRADIENT_RANGE_TOP_FLOAT,
    decay: Float = DEFAULT_DECAY,
    numStops: Int = DEFAULT_NUM_STOPS
): Modifier = composed {
    val colors = remember(color, numStops) {
        if (decay != DEFAULT_DECAY) {
            // If we have a non-linear decay, we need to create the color gradient steps
            // manually
            val baseAlpha = color.alpha
            List(numStops) { i ->
                val x = i * DEFAULT_DECAY / (numStops - 1)
                val opacity = x.pow(decay)
                color.copy(alpha = baseAlpha * opacity)
            }
        } else {
            // If we have a linear decay, we just create a simple list of start + end colors
            listOf(color.copy(alpha = GRADIENT_RANGE_BOTTOM_FLOAT), color)
        }
    }

    var height by remember { mutableStateOf(0f) }
    val brush = remember(color, numStops, startYPercentage, endYPercentage, height) {
        Brush.verticalGradient(
            colors = colors,
            startY = height * startYPercentage,
            endY = height * endYPercentage
        )
    }

    drawWithContent {
        drawContent()
        height = size.height
        drawRect(brush = brush)
    }.then(this)
}

/**
 * Draws a vertical gradient scrim in the background.
 *
 * @param color The color of the gradient scrim.
 * @param startYPercentage The start y value, in percentage of the layout's height (0f to 1f)
 * @param endYPercentage The end y value, in percentage of the layout's height (0f to 1f)
 * @param decay The exponential decay to apply to the gradient. Defaults to `1.0f` which is
 * a linear gradient.
 * @param numStops The number of color stops to draw in the gradient. Higher numbers result in
 * the higher visual quality at the cost of draw performance. Defaults to `16`.
 * @return A modifier the will draw a gradient in the composable background
 */
fun Modifier.verticalBackgroundGradientScrim(
    color: Color,
    @FloatRange(from = GRADIENT_RANGE_BOTTOM_FLOAT.toDouble(), to = GRADIENT_RANGE_TOP_FLOAT.toDouble())
    startYPercentage: Float = GRADIENT_RANGE_BOTTOM_FLOAT,
    @FloatRange(from = GRADIENT_RANGE_BOTTOM_FLOAT.toDouble(), to = GRADIENT_RANGE_TOP_FLOAT.toDouble())
    endYPercentage: Float = GRADIENT_RANGE_TOP_FLOAT,
    decay: Float = DEFAULT_DECAY,
    numStops: Int = DEFAULT_NUM_STOPS
): Modifier = composed {
    val colors = remember(color, numStops) {
        if (decay != DEFAULT_DECAY) {
            // If we have a non-linear decay, we need to create the color gradient steps
            // manually
            val baseAlpha = color.alpha
            List(numStops) { i ->
                val x = i * DEFAULT_DECAY / (numStops - 1)
                val opacity = x.pow(decay)
                color.copy(alpha = baseAlpha * opacity)
            }
        } else {
            // If we have a linear decay, we just create a simple list of start + end colors
            listOf(color.copy(alpha = GRADIENT_RANGE_BOTTOM_FLOAT), color)
        }
    }

    var height by remember { mutableStateOf(GRADIENT_RANGE_BOTTOM_FLOAT) }
    val brush = remember(color, numStops, startYPercentage, endYPercentage, height) {
        Brush.verticalGradient(
            colors = colors,
            startY = height * startYPercentage,
            endY = height * endYPercentage
        )
    }

    drawBehind {
        height = size.height
        drawRect(brush = brush)
    }.then(this)
}
