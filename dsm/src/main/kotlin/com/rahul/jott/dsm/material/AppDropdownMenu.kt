package com.rahul.jott.dsm.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.window.PopupProperties
import com.rahul.jott.dsm.component.internal.AppDropdownDefaults

/**
 * DSM used for creating dropdown menu
 *
 * @param modifier
 * @param expanded
 * @param offset
 * @param properties
 * @param dropDownItems
 * @param onDropDownItemClicked
 * @param onDismissRequest
 */
@Composable
fun AppDropdownMenu(
    modifier: Modifier = Modifier,
    width: Dp = AppDropdownDefaults.width,
    backgroundColor: Color = AppDropdownDefaults.backgroundColor,
    testTag: String? = null,
    expanded: Boolean = true,
    offset: DpOffset = DpOffset(AppDropdownDefaults.offsetX, AppDropdownDefaults.offsetY),
    properties: PopupProperties = PopupProperties(focusable = true),
    menuItemTextStyle: TextStyle = AppDropdownDefaults.textStyle,
    menuItemTextColor: Color = AppDropdownDefaults.textColor,
    dropDownItems: List<String>,
    onDropDownItemClicked: (Int) -> Unit,
    onDismissRequest: () -> Unit
) {
    DropdownMenu(
        modifier = modifier
            .testTag(testTag.orEmpty())
            .background(backgroundColor)
            .width(width),
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        properties = properties,
        offset = offset
    ) {
        dropDownItems.forEachIndexed { index, item ->
            DropdownMenuItem(
                onClick = {
                    onDropDownItemClicked(index)
                }
            ) {
                AppText(
                    text = item,
                    style = menuItemTextStyle,
                    color = menuItemTextColor
                )
            }
        }
    }
}
