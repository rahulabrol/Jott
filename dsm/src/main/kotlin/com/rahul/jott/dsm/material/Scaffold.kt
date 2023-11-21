package com.rahul.jott.dsm.material

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.rahul.jott.dsm.material.internal.AppScaffoldDefaults
import com.rahul.jott.dsm.theme.AppDarkTheme

/**
 * An App specific Material Design layout.
 *
 * Scaffold implements the basic material design visual layout structure.
 *
 * This component provides API to put together several material components to construct your
 * screen, by ensuring proper layout strategy for them and collecting necessary data so these
 * components will work together correctly.
 *
 * @param modifier An optional Modifier for the root of the [Scaffold]
 * @param scaffoldState State of this scaffold widget. It contains the state of the screen, e.g.
 * @param backgroundColor The background of the scaffold body
 * @param contentColor The color of the content in scaffold body.
 * @param floatingActionButtonPosition The position of the FAB on the screen. See [FabPosition] for
 * possible options available.
 * @param isFloatingActionButtonDocked whether [floatingActionButton] should overlap with
 * [bottomBar] for half a height, if [bottomBar] exists. Ignored if there's no [bottomBar] or no
 * [floatingActionButton].
 * @param floatingActionButton Main action button of your screen. Consider using
 * [FloatingActionButton] for this slot.
 * @param topBar The top app bar of the screen. Consider using [TopAppBar].
 * @param bottomBar A bottom bar of the screen. Consider using [BottomAppBar].
 * @param content content of your screen. The lambda receives an [PaddingValues] that should be
 * applied to the content root via Modifier.padding to properly offset top and bottom bars. If
 * you're using VerticalScroller, apply this modifier to the child of the scroller, and not on
 * the scroller itself.
 */
@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    backgroundColor: Color = AppScaffoldDefaults.BackgroundColor,
    contentColor: Color = AppScaffoldDefaults.ContentColor,
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    isFloatingActionButtonDocked: Boolean = AppScaffoldDefaults.IsFloatingActionButtonDocked,
    snackbarHost: @Composable (SnackbarHostState) -> Unit = {
        AppDarkTheme {
            AppSnackbar(
                snackbarHostState = it
            )
        }
    },
    floatingActionButton: @Composable () -> Unit = {},
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        snackbarHost = snackbarHost,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        isFloatingActionButtonDocked = isFloatingActionButtonDocked,
        floatingActionButtonPosition = floatingActionButtonPosition,
        floatingActionButton = floatingActionButton,
        topBar = topBar,
        bottomBar = bottomBar,
        content = content
    )
}
