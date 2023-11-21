package com.rahul.jott.dsm.material

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties
import com.rahul.jott.dsm.material.internal.AppAlertDialogDefaults
import com.rahul.jott.dsm.theme.AppTheme

/**
 * <a href="https://material.io/components/dialogs#alert-dialog" class="external" target="_blank">Material Design alert dialog</a>.
 *
 * Alert dialogs interrupt users with urgent information, details, or actions.
 *
 * ![Dialogs image](https://developer.android.com/images/reference/androidx/compose/material/dialogs.png)
 *
 * The dialog will position its buttons based on the available space. By default it will try to
 * place them horizontally next to each other and fallback to horizontal placement if not enough
 * space is available. There is also another version of this composable that has a slot for buttons
 * to provide custom buttons layout.
 *
 * Sample of dialog:
 * @sample androidx.compose.material.samples.AlertDialogSample
 *
 * @param onDismissRequest Executes when the user tries to dismiss the Dialog by clicking outside
 * or pressing the back button. This is not called when the dismiss button is clicked.
 * @param confirmButton A button which is meant to confirm a proposed action, thus resolving
 * what triggered the dialog. The dialog does not set up any events for this button so they need
 * to be set up by the caller.
 * @param modifier Modifier to be applied to the layout of the dialog.
 * @param dismissButton A button which is meant to dismiss the dialog. The dialog does not set up
 * any events for this button so they need to be set up by the caller.
 * @param title The title of the Dialog which should specify the purpose of the Dialog. The title
 * is not mandatory, because there may be sufficient information inside the [text]. Provided text
 * style will be [Typography.subtitle1].
 * @param text The text which presents the details regarding the Dialog's purpose. Provided text
 * style will be [Typography.body2].
 * @param shape Defines the Dialog's shape
 * @param containerColor The background color of the dialog.
 * @param properties Typically platform specific properties to further configure the dialog.
 */
@Composable
fun AppAlertDialog(
    modifier: Modifier = Modifier,
    shape: Shape = AppTheme.shapes.medium,
    tonalElevation: Dp = AppAlertDialogDefaults.Elevation,
    properties: DialogProperties = AppAlertDialogDefaults.dialogProperties,
    titleContentColor: Color = AppTheme.colors.textColor,
    textContentColor: Color = AppTheme.colors.textColor,
    containerColor: Color = AppTheme.colors.surface,
    iconContentColor: Color = AppTheme.colors.textColor,
    icon: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    confirmButton: @Composable () -> Unit,
    dismissButton: @Composable (() -> Unit)? = null,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = confirmButton,
        modifier = modifier,
        dismissButton = dismissButton,
        icon = icon,
        title = title,
        text = text,
        shape = shape,
        containerColor = containerColor,
        iconContentColor = iconContentColor,
        tonalElevation = tonalElevation,
        titleContentColor = titleContentColor,
        textContentColor = textContentColor,
        properties = properties,
    )
}

/**
 * @param modifier
 * @param text
 * @param testTag
 * @param onClick
 */
@Composable
fun AppAlertDialogButton(
    modifier: Modifier = Modifier,
    text: String,
    testTag: String? = null,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.apply {
            background(Color.Transparent)
            testTag?.let {
                testTag(testTag)
            }
        }
    ) {
        AppText(
            text = text,
            color = AppTheme.colors.primary,
            style = AppTheme.typography.button2,
        )
    }
}

/**
 * @param modifier
 * @param text
 * @param testTag
 * @param onClick
 */
@Composable
fun AppAlertDialogButton(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    testTag: String? = null,
    onClick: () -> Unit,
) = AppAlertDialogButton(
    modifier = modifier,
    text = LocalContext.current.resources.getString(text),
    testTag = testTag,
    onClick = onClick,
)

/**
 * @param text
 * @param textAlign
 * @param testTag
 */
@Composable
fun AppAlertDialogTitle(
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    testTag: String? = null,
) {
    AppText(
        modifier = Modifier
            .fillMaxWidth()
            .apply {
                testTag?.let {
                    testTag(testTag)
                }
            },
        textAlign = textAlign,
        text = text,
        style = AppTheme.typography.h6
    )
}

/**
 * @param text
 * @param textAlign
 * @param testTag
 */
@Composable
fun AppAlertDialogTitle(
    @StringRes text: Int,
    textAlign: TextAlign = TextAlign.Left,
    testTag: String? = null,
) = AppAlertDialogTitle(
    text = LocalContext.current.resources.getString(text),
    textAlign = textAlign,
    testTag = testTag,
)

/**
 * @param modifier
 * @param text
 * @param contentDescription
 * @param testTag
 */
@Composable
fun AppAlertDialogText(
    modifier: Modifier = Modifier,
    text: String,
    contentDescription: String? = null,
    testTag: String? = null,
) {
    AppText(
        text = text,
        modifier = modifier.apply {
            contentDescription?.let {
                semantics { this.contentDescription = contentDescription }
            }
            testTag?.let {
                testTag(testTag)
            }
        }
    )
}

/**
 * @param modifier
 * @param text
 * @param contentDescription
 * @param testTag
 */
@Composable
fun AppAlertDialogText(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    contentDescription: String? = null,
    testTag: String? = null,
) = AppAlertDialogText(
    modifier = modifier,
    text = LocalContext.current.resources.getString(text),
    contentDescription = contentDescription,
    testTag = testTag,
)
