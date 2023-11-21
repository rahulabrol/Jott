package com.rahul.jott.dsm.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Used for color configuration
 *
 * @property primary
 * @property primaryVariant
 * @property onPrimaryHighEmphasis
 * @property onPrimaryMediumEmphasis
 * @property secondary
 * @property secondaryVariant
 * @property onSecondary
 * @property background
 * @property backgroundSecondary
 * @property onBackgroundHighEmphasis
 * @property onBackgroundMediumEmphasis
 * @property surface
 * @property onSurfaceHighEmphasis
 * @property onSurfaceMediumEmphasis
 * @property error
 * @property notification
 * @property onError
 * @property disabled
 * @property onDisabled
 * @property textColor
 * @property colorControlNormal
 * @property colorControlSelected
 * @property outlineHighEmphasis
 * @property outlineMediumEmphasis
 */
@Immutable
data class AppColors(
    val primary: Color,
    val primaryVariant: Color,
    val onPrimaryHighEmphasis: Color,
    val onPrimaryMediumEmphasis: Color,
    val secondary: Color,
    val secondaryVariant: Color,
    val onSecondary: Color,
    val background: Color,
    val backgroundSecondary: Color,
    val onBackgroundHighEmphasis: Color,
    val onBackgroundMediumEmphasis: Color,
    val surface: Color,
    val onSurfaceHighEmphasis: Color,
    val onSurfaceMediumEmphasis: Color,
    val error: Color,
    val notification: Color,
    val onError: Color,
    val disabled: Color,
    val onDisabled: Color,
    val textColor: Color,
    val colorControlNormal: Color,
    val colorControlSelected: Color,
    val outlineHighEmphasis: Color,
    val outlineMediumEmphasis: Color
)
