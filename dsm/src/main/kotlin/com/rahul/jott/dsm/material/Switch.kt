package com.rahul.jott.dsm.material

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rahul.jott.dsm.material.internal.AppSwitchDefaults

/**
 * <a href="https://material.io/components/switches" class="external" target="_blank">An app specific Material Design switch</a>.
 *
 * Switches toggle the state of a single item on or off.
 *
 * [Switches image](https://developer.android.com/images/reference/androidx/compose/material/switches.png)
 *
 *
 * @param checked whether or not this component is checked
 * @param onCheckedChange callback to be invoked when Switch is being clicked,
 * therefore the change of checked state is requested.  If null, then this is passive
 * and relies entirely on a higher-level component to control the "checked" state.
 * @param modifier Modifier to be applied to the switch layout
 * @param enabled whether the component is enabled or grayed out
 * @param colors [SwitchColors] that will be used to determine the color of the thumb and track
 * in different states. See [AppSwitchDefaults.colors].
 */
@Composable
fun AppSwitch(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: SwitchColors = AppSwitchDefaults.colors(),
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
    )
}
