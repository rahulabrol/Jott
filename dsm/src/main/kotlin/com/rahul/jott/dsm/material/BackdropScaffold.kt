package com.rahul.jott.dsm.material

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.material.internal.AppBackdropScaffoldDefaults
import com.rahul.jott.dsm.theme.AppDarkTheme

/**
 * An App specific Material Design layout.
 *
 * @param appBar App bar for the back layer. Make sure that the [peekHeight] is equal to the
 * height of the app bar, so that the app bar is fully visible. Consider using [TopAppBar] but
 * set the elevation to 0dp and background color to transparent as a surface is already provided.
 * @param backLayerContent The content of the back layer.
 * @param frontLayerContent The content of the front layer.
 * @param modifier Optional [Modifier] for the root of the scaffold.
 * @param scaffoldState The state of the scaffold.
 * @param backLayerBackgroundColor The background color of the back layer.
 * @param backLayerContentColor The preferred content color provided by the back layer to its
 * children. Defaults to the matching content color for [backLayerBackgroundColor], or if that
 * is not a color from the theme, this will keep the same content color set above the back layer.
 * @param frontLayerBackgroundColor The background color of the front layer.
 * @param frontLayerContentColor The preferred content color provided by the back front to its
 * children. Defaults to the matching content color for [frontLayerBackgroundColor], or if that
 * is not a color from the theme, this will keep the same content color set above the front layer.
 * @param snackbarHost The component hosting the snackbars shown inside the scaffold.
 */
@Composable
@ExperimentalMaterialApi
fun AppBackdropScaffold(
    modifier: Modifier = Modifier,
    scaffoldState: BackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed),
    gesturesEnabled: Boolean = true,
    stickyFrontLayer: Boolean = true,
    backLayerBackgroundColor: Color = AppBackdropScaffoldDefaults.BackLayerBackgroundColor,
    backLayerContentColor: Color = AppBackdropScaffoldDefaults.BackLayerContentColor,
    frontLayerBackgroundColor: Color = AppBackdropScaffoldDefaults.FrontLayerBackgroundColor,
    frontLayerContentColor: Color = AppBackdropScaffoldDefaults.FrontLayerContentColor,
    frontLayerScrimColor: Color = BackdropScaffoldDefaults.frontLayerScrimColor,
    frontLayerShape: CornerBasedShape = AppBackdropScaffoldDefaults.FrontLayerShape,
    snackbarHost: @Composable (SnackbarHostState) -> Unit = {
        AppDarkTheme {
            AppSnackbar(
                snackbarHostState = it
            )
        }
    },
    appBar: @Composable () -> Unit,
    backLayerContent: @Composable () -> Unit,
    frontLayerContent: @Composable () -> Unit,
) {
    BackdropScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        gesturesEnabled = gesturesEnabled,
        snackbarHost = snackbarHost,
        backLayerBackgroundColor = backLayerBackgroundColor,
        backLayerContentColor = backLayerContentColor,
        frontLayerBackgroundColor = frontLayerBackgroundColor,
        frontLayerContentColor = frontLayerContentColor,
        frontLayerShape = frontLayerShape,
        appBar = appBar,
        backLayerContent = backLayerContent,
        frontLayerContent = frontLayerContent,
        frontLayerScrimColor = frontLayerScrimColor,
        stickyFrontLayer = stickyFrontLayer,
        peekHeight = 57.dp // TODO https://issuetracker.google.com/issues/266347215
    )
}
