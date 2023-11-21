package com.rahul.jott.dsm.theme.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.rahul.jott.dsm.R
import com.rahul.jott.dsm.theme.AppColors

private val JottBlue
    @Composable get() = colorResource(id = R.color.jott_blue)
private val LightBlue
    @Composable get() = colorResource(id = R.color.light_blue)
private val DarkBlue
    @Composable get() = colorResource(id = R.color.dark_blue)
private val DarkerBlue
    @Composable get() = colorResource(id = R.color.darker_blue)
private val DarkestBlue
    @Composable get() = colorResource(id = R.color.darkest_blue)
private val LateNightSurfaceBlue
    @Composable get() = colorResource(id = R.color.late_night_surface_blue)
private val DarkerBlue38 // 38% Opacity
    @Composable get() = colorResource(id = R.color.darker_blue_38)
private val ToneBlue
    @Composable get() = colorResource(id = R.color.tone_blue)
private val Green
    @Composable get() = colorResource(id = R.color.green)
private val LightGreen
    @Composable get() = colorResource(id = R.color.light_green)
private val HighlightGreen
    @Composable get() = colorResource(id = R.color.highlight_green)
private val DarkGreen
    @Composable get() = colorResource(id = R.color.dark_green)
private val Gray
    @Composable get() = colorResource(id = R.color.gray)
private val LightGray
    @Composable get() = colorResource(id = R.color.light_gray)
private val BaseGray
    @Composable get() = colorResource(id = R.color.base_gray)
private val BlueGray
    @Composable get() = colorResource(id = R.color.blue_gray)
private val White
    @Composable get() = colorResource(id = R.color.white)
private val White38 // 38% Opacity
    @Composable get() = colorResource(id = R.color.white_38)
private val White60 // 60% Opacity
    @Composable get() = colorResource(id = R.color.white_38)
private val Red
    @Composable get() = colorResource(id = R.color.red)
private val LightRed
    @Composable get() = colorResource(id = R.color.light_red)
private val DarkRed
    @Composable get() = colorResource(id = R.color.dark_red)
private val Orange
    @Composable get() = colorResource(id = R.color.orange)
private val LightOrange
    @Composable get() = colorResource(id = R.color.light_orange)
private val DarkOrange
    @Composable get() = colorResource(id = R.color.dark_orange)
private val Yellow
    @Composable get() = colorResource(id = R.color.yellow)
private val DarkYellow
    @Composable get() = colorResource(id = R.color.dark_yellow)
private val VipGold
    @Composable get() = colorResource(id = R.color.vip_gold)
private val VipPlatinum
    @Composable get() = colorResource(id = R.color.vip_platinum)
private val Black
    @Composable get() = colorResource(id = R.color.black)

/**
 * Compose Dark theme color palette.
 * Currently not supported.
 * Leaving this here for future support
 */
internal val AppMainDarkColors
    @Composable
    get() = defaultAppColors()

/**
 * Compose Light/Default theme color palette.
 */
internal val AppMainLightColors
    @Composable
    get() = defaultAppColors()

internal val AppAlertColors
    @Composable
    get() = defaultAppColors().copy(
        primary = Yellow,
        secondary = DarkYellow,
        background = Yellow
    )

internal val AppBenefitColors
    @Composable
    get() = defaultAppColors().copy(
        primary = Green,
        secondary = DarkGreen,
        background = LightGreen,
        backgroundSecondary = HighlightGreen
    )

internal val AppHighlightColors
    @Composable
    get() = defaultAppColors().copy(
        primary = Orange,
        secondary = DarkOrange,
        background = LightOrange
    )

internal val AppWarningColors
    @Composable
    get() = defaultAppColors().copy(
        primary = Red,
        secondary = DarkRed,
        background = LightRed
    )

internal val AppVipColors
    @Composable
    get() = defaultAppColors().copy(
        primary = DarkBlue
    )

internal val AppVipBlueColors
    @Composable
    get() = defaultAppColors().copy(
        primary = JottBlue
    )

internal val AppVipGoldColors
    @Composable
    get() = defaultAppColors().copy(
        primary = VipGold
    )

internal val AppVipPlatinumColors
    @Composable
    get() = defaultAppColors().copy(
        primary = VipPlatinum
    )

internal val AppDisabledColors
    @Composable
    get() = defaultAppColors().copy(
        primary = DarkBlue,
        surface = White38,
        onSecondary = White38
    )

internal val AppEditColors
    @Composable
    get() = defaultAppColors().copy(
        surface = JottBlue,
        primary = White,
        primaryVariant = White,
        textColor = White,
        background = DarkBlue,
        onSurfaceHighEmphasis = White,
        onPrimaryHighEmphasis = JottBlue,
    )

internal val AppDarkColors
    @Composable
    get() = defaultAppColors().copy(
        primary = ToneBlue,
        primaryVariant = White,
        textColor = White,
        background = DarkerBlue,
        backgroundSecondary = DarkerBlue,
        outlineMediumEmphasis = DarkerBlue,
        onSurfaceMediumEmphasis = LightBlue,
        onSurfaceHighEmphasis = White,
        onBackgroundMediumEmphasis = LightBlue,
        onBackgroundHighEmphasis = White,
        surface = LateNightSurfaceBlue
    )

internal val LocalAppColorsProvider: ProvidableCompositionLocal<AppColors> =
    staticCompositionLocalOf {
        AppColors(
            primary = Color.Unspecified,
            primaryVariant = Color.Unspecified,
            onPrimaryHighEmphasis = Color.Unspecified,
            onPrimaryMediumEmphasis = Color.Unspecified,
            secondary = Color.Unspecified,
            secondaryVariant = Color.Unspecified,
            onSecondary = Color.Unspecified,
            background = Color.Unspecified,
            backgroundSecondary = Color.Unspecified,
            onBackgroundHighEmphasis = Color.Unspecified,
            onBackgroundMediumEmphasis = Color.Unspecified,
            surface = Color.Unspecified,
            onSurfaceHighEmphasis = Color.Unspecified,
            onSurfaceMediumEmphasis = Color.Unspecified,
            error = Color.Unspecified,
            notification = Color.Unspecified,
            onError = Color.Unspecified,
            disabled = Color.Unspecified,
            onDisabled = Color.Unspecified,
            textColor = Color.Unspecified,
            colorControlNormal = Color.Unspecified,
            colorControlSelected = Color.Unspecified,
            outlineHighEmphasis = Color.Unspecified,
            outlineMediumEmphasis = Color.Unspecified
        )
    }

@Composable
private fun defaultAppColors() = AppColors(
    primary = JottBlue,
    primaryVariant = DarkBlue,
    onPrimaryHighEmphasis = White,
    onPrimaryMediumEmphasis = White60,
    secondary = Green,
    secondaryVariant = DarkGreen,
    onSecondary = White,
    background = BaseGray,
    backgroundSecondary = LightBlue,
    onBackgroundHighEmphasis = DarkerBlue,
    onBackgroundMediumEmphasis = BlueGray,
    surface = White,
    onSurfaceHighEmphasis = DarkerBlue,
    onSurfaceMediumEmphasis = BlueGray,
    error = Red,
    notification = Red,
    onError = White,
    disabled = DarkerBlue38,
    onDisabled = White38,
    textColor = DarkerBlue,
    colorControlNormal = BlueGray,
    colorControlSelected = JottBlue,
    outlineHighEmphasis = Gray,
    outlineMediumEmphasis = LightGray
)
