package com.rahul.jott.dsm.material

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rahul.jott.dsm.material.internal.AppCheckboxDefaults

/**
 * <a href="https://material.io/components/checkboxes" class="external" target="_blank">An app specific Material Design checkbox</a>.
 *
 * Checkboxes allow users to select one or more items from a set. Checkboxes can turn an option on
 * or off.
 *
 * [Checkboxes image](https://developer.android.com/images/reference/androidx/compose/material/checkboxes.png)
 *
 * @param checked whether Checkbox is checked or unchecked
 * @param onCheckedChange callback to be invoked when checkbox is being clicked,
 * therefore the change of checked state in requested.  If null, then this is passive
 * and relies entirely on a higher-level component to control the "checked" state.
 * @param modifier Modifier to be applied to the layout of the checkbox
 * @param enabled whether the component is enabled or grayed out
 * @param colors [CheckboxColors] that will be used to determine the color of the checkmark / box
 * / border in different states. See [AppCheckboxDefaults.colors].
 */
@Composable
fun AppCheckbox(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CheckboxColors = AppCheckboxDefaults.colors(),
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?
) {
    Checkbox(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        enabled = enabled,
        colors = colors
    )
}
