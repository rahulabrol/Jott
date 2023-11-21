package com.rahul.jott.dsm.material.internal

import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.rahul.jott.dsm.theme.AppTheme

object AppCheckboxDefaults {
    /**
     * Creates a [CheckboxColors] that will animate between the provided colors.
     *
     * @param checkedColor the color that will be used for the border and box when checked
     * @param uncheckedColor color that will be used for the border when unchecked
     * @param checkmarkColor color that will be used for the checkmark when checked
     * @param disabledColor color that will be used for the box and border when disabled
     * @param disabledIndeterminateColor color that will be used for the box and
     * border in a [TriStateCheckbox] when disabled AND in an [ToggleableState.Indeterminate] state.
     */
    @Composable
    fun colors(
        checkedColor: Color = AppTheme.colors.primary,
        uncheckedColor: Color = AppTheme.colors.textColor,
        checkmarkColor: Color = AppTheme.colors.surface,
        disabledColor: Color = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = ContentAlpha.disabled),
        disabledIndeterminateColor: Color = checkedColor.copy(alpha = ContentAlpha.disabled)
    ): CheckboxColors = CheckboxDefaults.colors(
        checkedColor = checkedColor,
        uncheckedColor = uncheckedColor,
        checkmarkColor = checkmarkColor,
        disabledColor = disabledColor,
        disabledIndeterminateColor = disabledIndeterminateColor
    )
}
