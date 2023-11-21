package com.rahul.jott.dsm.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

/**
 * @property defaultFontFamily
 * @property h1
 * @property h2
 * @property h3
 * @property h4
 * @property h5
 * @property subtitle1
 * @property subtitle2
 * @property body1
 * @property body2
 * @property body3
 * @property button1
 * @property button2
 * @property overline
 * @property h6
 * @property body4
 */
@Immutable
data class AppTypography(
    val defaultFontFamily: FontFamily,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val h6: TextStyle,
    val subtitle1: TextStyle,
    val subtitle2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
    val button1: TextStyle,
    val button2: TextStyle,
    val overline: TextStyle
)
