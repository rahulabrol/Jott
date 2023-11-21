package com.rahul.jott.dsm.component.internal

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.material.internal.AppButtonDefaults
import com.rahul.jott.dsm.theme.AppTheme

object SearchFieldDefaults {
    private const val ELEVATION = 0
    private const val HORIZONTAL_PADDING = 16
    private const val VERTICAL_PADDING = 8
    private const val MAIN_CONTENT_START_MARGIN = 12
    private const val MAIN_CONTENT_HORIZONTAL_BIAS = 0f

    /**
     * The default start margin between content start and the main content
     */
    const val MainContentStartMargin: Int = MAIN_CONTENT_START_MARGIN

    /**
     * The default horizontal bias of the main content. This will align the main content
     * to the Start
     */
    const val MainContentHorizontalBias: Float = MAIN_CONTENT_HORIZONTAL_BIAS

    /**
     * The default padding for a search field
     */
    val padding: PaddingValues = PaddingValues(
        horizontal = HORIZONTAL_PADDING.dp,
        vertical = VERTICAL_PADDING.dp
    )

    /**
     * The default role for a search field
     */
    val FieldRole: Role = Role.Button

    /**
     * The default height for a search field
     */
    val Height: Dp
        @Composable
        get() = AppButtonDefaults.HeightNormal

    /**
     * The default shape radius for a search field
     */
    val Shape: CornerBasedShape
        @Composable
        get() = AppTheme.shapes.large

    /**
     * The default elevation for a search field
     */
    val Elevation: Dp
        @Composable
        get() = ELEVATION.dp

    /**
     * The default color for a search field
     */
    val BackgroundColor: Color
        @Composable
        get() = AppTheme.colors.background

    /**
     * A fun that returns the location text in the proper styled format.
     * This fun will style the the initial text before the [delimiter] in [FontWeight.Bold] and
     * append the rest of the location text after that.
     *
     * @return The location styled text
     */
    fun styledLocationText(
        text: String,
        delimiter: Int = 3,
        textStyle: TextStyle
    ): AnnotatedString =
        buildAnnotatedString {
            val airport = text.substring(0, delimiter)
            val location = text.substring(delimiter, text.length)
            withStyle(
                SpanStyle(
                    fontWeight = textStyle.fontWeight,
                    letterSpacing = textStyle.letterSpacing,
                    fontSize = textStyle.fontSize
                )
            ) {
                append(airport)
            }
            append(location)
        }
}
