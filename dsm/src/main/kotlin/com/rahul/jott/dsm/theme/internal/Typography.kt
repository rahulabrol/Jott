package com.rahul.jott.dsm.theme.internal

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rahul.jott.dsm.R
import com.rahul.jott.dsm.theme.AppTypography

// region Font Size Constants
internal const val FontSizeH1 = 34
internal const val FontSizeH2 = 24
internal const val FontSizeH3 = 20
internal const val FontSizeH4 = 18
internal const val FontSizeH5 = 16
internal const val FontSizeH6 = 14
internal const val FontSizeSubtitle1 = 14
internal const val FontSizeSubtitle2 = 12
internal const val FontSizeBody1 = 16
internal const val FontSizeBody2 = 14
internal const val FontSizeBody3 = 12
internal const val FontSizeBody4 = 10
internal const val FontSizeButton1 = 16
internal const val FontSizeButton2 = 14
internal const val FontSizeOverline = 10
internal const val DefaultFontSize = 14
// endregion

// region Letter Spacing Constants
private const val LetterSpacingH1 = -0.015_625
private const val LetterSpacingH2 = -0.008_333_333_33
private const val LetterSpacingH3 = 0
private const val LetterSpacingH4 = 0.007_352_941_18
private const val LetterSpacingH5 = 0
private const val LetterSpacingH6 = 0.012_5
private const val LetterSpacingSubtitle1 = 0.009_375
private const val LetterSpacingSubtitle2 = 0.007_142_857_14
private const val LetterSpacingBody1 = 0.031_25
private const val LetterSpacingBody2 = 0.017_857_142_9
private const val LetterSpacingBody3 = 0.017_857_142_9
private const val LetterSpacingBody4 = 0.017_857_142_9
private const val LetterSpacingButton1 = 0.089_28_714_3
private const val LetterSpacingButton2 = 0.089_28_714_3
private const val LetterSpacingOverline = 0.166_666_667
// endregion

// region Line Height
private const val LineHeightH1 = 36
private const val LineHeightH2 = 32
private const val LineHeightH3 = 24
private const val LineHeightH4 = 21
private const val LineHeightH5 = 20
private const val LineHeightH6 = 18
private const val LineHeightSubtitle1 = 18
private const val LineHeightSubtitle2 = 16
private const val LineHeightBody1 = 20
private const val LineHeightBody2 = 18
private const val LineHeightBody3 = 16
private const val LineHeightBody4 = 14
private const val LineHeightButton1 = 16
private const val LineHeightButton2 = 14
private const val LineHeightOverline = 14
// endregion

/**
 * Compose custom font to set as the app default.
 */
private
val RobotoFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.roboto_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resId = R.font.roboto_bold,
            weight = FontWeight.Bold
        ),
        Font(
            resId = R.font.roboto_medium,
            weight = FontWeight.Medium
        )
    )
)

/**
 * Compose Global Theme typography config
 */
internal val Typography = AppTypography(
    defaultFontFamily = RobotoFontFamily,
    h1 = TextStyle(
        fontSize = FontSizeH1.sp,
        letterSpacing = (LetterSpacingH1).sp,
        lineHeight = LineHeightH1.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FontSizeH2.sp,
        letterSpacing = (LetterSpacingH2).sp,
        lineHeight = LineHeightH2.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = FontSizeH3.sp,
        letterSpacing = LetterSpacingH3.sp,
        lineHeight = LineHeightH3.sp
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FontSizeH4.sp,
        letterSpacing = LetterSpacingH4.sp,
        lineHeight = LineHeightH4.sp
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FontSizeH5.sp,
        letterSpacing = LetterSpacingH5.sp,
        lineHeight = LineHeightH5.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FontSizeH6.sp,
        letterSpacing = LetterSpacingH6.sp,
        lineHeight = LineHeightH6.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = FontSizeSubtitle1.sp,
        letterSpacing = LetterSpacingSubtitle1.sp,
        lineHeight = LineHeightSubtitle1.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FontSizeSubtitle2.sp,
        letterSpacing = LetterSpacingSubtitle2.sp,
        lineHeight = LineHeightSubtitle2.sp
    ),
    body1 = TextStyle(
        fontSize = FontSizeBody1.sp,
        letterSpacing = LetterSpacingBody1.sp,
        lineHeight = LineHeightBody1.sp
    ),
    body2 = TextStyle(
        fontSize = FontSizeBody2.sp,
        letterSpacing = LetterSpacingBody2.sp,
        lineHeight = LineHeightBody2.sp
    ),
    body3 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = FontSizeBody3.sp,
        letterSpacing = LetterSpacingBody3.sp,
        lineHeight = LineHeightBody3.sp
    ),
    body4 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FontSizeBody4.sp,
        letterSpacing = LetterSpacingBody4.sp,
        lineHeight = LineHeightBody4.sp
    ),
    button1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FontSizeButton1.sp,
        letterSpacing = LetterSpacingButton1.sp,
        lineHeight = LineHeightButton1.sp
    ),
    button2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FontSizeButton2.sp,
        letterSpacing = LetterSpacingButton2.sp,
        lineHeight = LineHeightButton2.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FontSizeOverline.sp,
        letterSpacing = LetterSpacingOverline.sp,
        lineHeight = LineHeightOverline.sp
    )
)

internal val LocalAppTypographyProvider: ProvidableCompositionLocal<AppTypography> =
    staticCompositionLocalOf {
        AppTypography(
            defaultFontFamily = FontFamily.Default,
            h1 = TextStyle.Default,
            h2 = TextStyle.Default,
            h3 = TextStyle.Default,
            h4 = TextStyle.Default,
            h5 = TextStyle.Default,
            h6 = TextStyle.Default,
            subtitle1 = TextStyle.Default,
            subtitle2 = TextStyle.Default,
            body1 = TextStyle.Default,
            body2 = TextStyle.Default,
            body3 = TextStyle.Default,
            body4 = TextStyle.Default,
            button1 = TextStyle.Default,
            button2 = TextStyle.Default,
            overline = TextStyle.Default,
        )
    }
