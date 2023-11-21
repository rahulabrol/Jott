package com.rahul.jott.dsm.material

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties

/**
 * The popup is positioned relative to its parent, using the alignment and offset.
 * The popup is visible as long as it is part of the composition hierarchy.
 *
 * @param alignment - The alignment relative to the parent.
 * @param offset - An offset from the original aligned position of the popup.
 * Offset respects the Ltr/Rtl context, thus in Ltr it will be added to the original aligned position and in Rtl it will be subtracted from it.
 * @param properties - PopupProperties for further customization of this popup's behavior.
 * @param onDismissRequest - Executes when the user clicks outside of the popup.
 * @param content - The content to be displayed inside the popup.
 */
@Composable
fun AppPopUp(
    alignment: Alignment = Alignment.TopStart,
    offset: IntOffset = IntOffset(0, 0),
    properties: PopupProperties = PopupProperties(),
    onDismissRequest: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Popup(
        alignment = alignment,
        offset = offset,
        onDismissRequest = onDismissRequest,
        properties = properties,
        content = content
    )
}

/**
 * The popup is positioned using a custom popupPositionProvider.
 *
 * @param popupPositionProvider - Provides the screen position of the popup.
 * @param properties - PopupProperties for further customization of this popup's behavior.
 * @param onDismissRequest - Executes when the user clicks outside of the popup.
 * @param content - The content to be displayed inside the popup.
 */
@Composable
fun AppPopUp(
    popupPositionProvider: PopupPositionProvider,
    properties: PopupProperties = PopupProperties(),
    onDismissRequest: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Popup(
        popupPositionProvider = popupPositionProvider,
        onDismissRequest = onDismissRequest,
        properties = properties,
        content = content
    )
}
