package com.rahul.jott.dsm.component.internal

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.theme.AppTheme

/**
 * The app search bar defaults
 */
object AppSearchBarDefaults {
    private const val DEFAULT_ELEVATION = 0
    private const val DEFAULT_TEXT_FIELD_HEIGHT = 56
    private const val DEFAULT_UNFOCUSED_INDICATOR_COLOR_ALPHA = 0.5f

    /**
     * The app search bar default background color
     */
    val BackgroundColor: Color
        @Composable get() = AppTheme.colors.primary

    /**
     * The app search bar default content color
     */
    val ContentColor: Color
        @Composable get() = AppTheme.colors.primary

    /**
     * The app search bar default elevation
     */
    val Elevation: Dp
        @Composable get() = DEFAULT_ELEVATION.dp

    /**
     * The app search bar default icon tint
     */
    val IconTint: Color
        @Composable get() = AppTheme.colors.onPrimaryHighEmphasis

    /**
     * The app search bar default text field height
     */
    val TextFieldHeight: Dp
        @Composable get() = DEFAULT_TEXT_FIELD_HEIGHT.dp

    /**
     * The app search bar default keyboard options
     */
    val KeyboardOptions: KeyboardOptions
        @Composable get() = KeyboardOptions(
            imeAction = ImeAction.Done
        )

    /**
     * The app search bar default text field colors
     */
    val TextFieldColors: TextFieldColors
        @Composable get() = TextFieldDefaults.textFieldColors(
            backgroundColor = AppTheme.colors.primary,
            cursorColor = AppTheme.colors.onPrimaryHighEmphasis,
            textColor = AppTheme.colors.onPrimaryHighEmphasis,
            focusedIndicatorColor = AppTheme.colors.onPrimaryHighEmphasis,
            unfocusedIndicatorColor = AppTheme.colors.background.copy(alpha = DEFAULT_UNFOCUSED_INDICATOR_COLOR_ALPHA),
        )

    /**
     * The app search bar default label text style
     */
    val LabelTextStyle: TextStyle
        @Composable get() = AppTheme.typography.subtitle2

    /**
     * The app search bar default label text color
     */
    val LabelTextColor: Color
        @Composable get() = AppTheme.colors.onPrimaryHighEmphasis

    /**
     * The app search bar default place holder text style
     */
    val PlaceHolderTextStyle: TextStyle
        @Composable get() = AppTheme.typography.body1

    /**
     * The app search bar default place holder text color
     */
    val PlaceHolderTextColor: Color
        @Composable get() = AppTheme.colors.onPrimaryHighEmphasis
}
