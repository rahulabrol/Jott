package com.rahul.jott.dsm.theme.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.rahul.jott.dsm.theme.AppTheme

internal object AppTextStyle {
    /**
     * This property defines the text defaults for the app.
     *
     */
    val Default: TextStyle
        @Composable
        get() = TextStyle(
            color = AppTheme.colors.textColor,
            fontSize = DefaultFontSize.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = Typography.defaultFontFamily,
            background = Color.Transparent,
            textDecoration = TextDecoration.None,
            shadow = Shadow.None,
            textAlign = TextAlign.Start,
            lineHeight = TextUnit.Unspecified,
            textIndent = TextIndent.None
        )
}
