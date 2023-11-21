package com.rahul.jott.dsm.material.internal

import androidx.compose.material.ContentAlpha
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import com.rahul.jott.dsm.theme.AppTheme

/**
 * Contains the default values used by [AppSwitch]
 */
object AppSwitchDefaults {
    /**
     * Creates a [SwitchColors] that represents the different colors used in a [Switch] in
     * different states.
     *
     * @param checkedThumbColor the color used for the thumb when enabled and checked
     * @param checkedTrackColor the color used for the track when enabled and checked
     * @param checkedTrackAlpha the alpha applied to [checkedTrackColor] and
     * [disabledCheckedTrackColor]
     * @param uncheckedThumbColor the color used for the thumb when enabled and unchecked
     * @param uncheckedTrackColor the color used for the track when enabled and unchecked
     * @param uncheckedTrackAlpha the alpha applied to [uncheckedTrackColor] and
     * [disabledUncheckedTrackColor]
     * @param disabledCheckedThumbColor the color used for the thumb when disabled and checked
     * @param disabledCheckedTrackColor the color used for the track when disabled and checked
     * @param disabledUncheckedThumbColor the color used for the thumb when disabled and unchecked
     * @param disabledUncheckedTrackColor the color used for the track when disabled and unchecked
     */
    @Composable
    fun colors(
        checkedThumbColor: Color = AppTheme.colors.onPrimaryHighEmphasis,
        checkedTrackColor: Color = AppTheme.colors.primary,
        checkedTrackAlpha: Float = 1f,
        uncheckedThumbColor: Color = AppTheme.colors.onSurfaceMediumEmphasis,
        uncheckedTrackColor: Color = AppTheme.colors.onPrimaryMediumEmphasis,
        uncheckedBorderColor: Color = AppTheme.colors.outlineHighEmphasis,
        uncheckedTrackAlpha: Float = 1f,
        disabledCheckedThumbColor: Color = checkedThumbColor
            .copy(alpha = ContentAlpha.disabled)
            .compositeOver(AppTheme.colors.surface),
        disabledCheckedTrackColor: Color = checkedTrackColor
            .copy(alpha = ContentAlpha.disabled)
            .compositeOver(AppTheme.colors.surface),
        disabledUncheckedThumbColor: Color = uncheckedThumbColor
            .copy(alpha = ContentAlpha.disabled)
            .compositeOver(AppTheme.colors.surface),
        disabledUncheckedTrackColor: Color = uncheckedTrackColor
            .copy(alpha = ContentAlpha.disabled)
            .compositeOver(AppTheme.colors.surface)
    ): SwitchColors = SwitchDefaults.colors(
        checkedThumbColor = checkedThumbColor,
        checkedTrackColor = checkedTrackColor.copy(alpha = checkedTrackAlpha),
        uncheckedThumbColor = uncheckedThumbColor,
        uncheckedTrackColor = uncheckedTrackColor.copy(alpha = uncheckedTrackAlpha),
        disabledCheckedThumbColor = disabledCheckedThumbColor,
        disabledCheckedTrackColor = disabledCheckedTrackColor.copy(alpha = checkedTrackAlpha),
        disabledUncheckedThumbColor = disabledUncheckedThumbColor,
        disabledUncheckedTrackColor = disabledUncheckedTrackColor.copy(alpha = uncheckedTrackAlpha),
        uncheckedBorderColor = uncheckedBorderColor
    )
}
