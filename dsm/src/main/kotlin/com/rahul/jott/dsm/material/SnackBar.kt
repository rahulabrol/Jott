package com.rahul.jott.dsm.material

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.rahul.jott.dsm.material.internal.AppButtonDefaults
import com.rahul.jott.dsm.material.internal.AppSnackbarDefaults
import com.rahul.jott.dsm.theme.AppTheme

/**
 * <a href="https://material.io/components/snackbars" class="external" target="_blank">An app specific Material Design snackbar</a>.
 *
 * Snackbars provide brief messages about app processes at the bottom of the screen.
 *
 * Snackbars inform users of a process that an app has performed or will perform. They appear
 * temporarily, towards the bottom of the screen. They shouldn’t interrupt the user experience,
 * and they don’t require user input to disappear.
 *
 * A Snackbar can contain a single action. Because Snackbar disappears automatically, the action
 * shouldn't be "Dismiss" or "Cancel".
 *
 * [Snackbars image](https://developer.android.com/images/reference/androidx/compose/material/snackbars.png)
 *
 * This components provides only the visuals of the [AppSnackbar]. If you need to show a [AppSnackbar]
 * with defaults on the screen, use [ScaffoldState.snackbarHostState] and
 * [SnackbarHostState.showSnackbar]:
 *
 *
 * @param modifier modifiers for the Snackbar layout
 * @param actionOnNewLine whether or not action should be put on the separate line. Recommended
 * for action with long action text
 * @param shape Defines the Snackbar's shape as well as its shadow
 * @param backgroundColor background color of the Snackbar
 * @param contentColor color of the content to use inside the snackbar. Defaults to
 * either the matching content color for [backgroundColor], or, if it is not a color from
 * the theme, this will keep the same value set above this Surface.
 * @param elevation The z-coordinate at which to place the SnackBar. This controls the size
 * of the shadow below the SnackBar
 * @param content content to show information about a process that an app has performed or will
 * perform. Will show a default text if non custom content was passed.
 */
@Composable
fun AppSnackbar(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    shape: Shape = AppSnackbarDefaults.Shape,
    backgroundColor: Color = AppSnackbarDefaults.BackgroundColor,
    contentColor: Color = AppTheme.colors.surface,
    elevation: Dp = AppSnackbarDefaults.Elevation,
    actionOnNewLine: Boolean = AppSnackbarDefaults.ActionOnNewLine,
    actionColor: Color = AppSnackbarDefaults.PrimaryActionColor,
    content: @Composable () -> Unit = {
        snackbarHostState.currentSnackbarData?.let {
            AppSnackBarText(it.message)
        }
    }
) {
    SnackbarHost(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Bottom),
        hostState = snackbarHostState,
    ) { data ->
        val actionLabel = data.actionLabel
        val actionComposable: (@Composable () -> Unit)? = actionLabel?.let {
            @Composable {
                AppTextButton(
                    colors = AppButtonDefaults.textButtonColors(contentColor = actionColor),
                    onClick = { data.performAction() },
                    content = {
                        Text(
                            text = actionLabel,
                            color = actionColor
                        )
                    }
                )
            }
        }

        Snackbar(
            modifier = Modifier
                .padding(
                    all = AppSnackbarDefaults.Padding
                ),
            action = actionComposable,
            actionOnNewLine = actionOnNewLine,
            shape = shape,
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            elevation = elevation,
            content = content
        )
    }
}

/**
 * @param message
 */
@Composable
fun AppSnackBarText(message: String) {
    AppText(
        text = message,
        style = AppTheme.typography.body2,
        color = AppTheme.colors.onPrimaryHighEmphasis
    )
}
