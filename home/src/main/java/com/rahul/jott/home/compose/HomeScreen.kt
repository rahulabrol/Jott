package com.rahul.jott.home.compose

import android.content.res.Resources
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rahul.jott.dsm.R
import com.rahul.jott.dsm.material.AppBottomNavigation
import com.rahul.jott.dsm.material.AppBottomNavigationItem
import com.rahul.jott.dsm.material.AppBottomNavigationItemIcon
import com.rahul.jott.dsm.material.AppBottomNavigationItemText
import com.rahul.jott.dsm.material.AppScaffold
import com.rahul.jott.dsm.material.AppTopAppBar
import com.rahul.jott.dsm.theme.AppTheme
import com.rahul.jott.global.base.utils.asString
import com.rahul.jott.home.compose.navigation.HomeNavigation
import com.rahul.jott.home.state.HomeBottomNavigationBarStateHolder
import com.rahul.jott.home.state.HomeViewModel
import com.rahul.jott.home.state.NetworkConnectivityStateHolder
import com.rahul.jott.home.util.HomeTestTags
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * The public entry point to display the HomeScreen screen
 *
 * @param modifier An ordered, immutable collection of modifier elements
 *     that decorate or add behavior to Compose UI elements. For
 *     example, backgrounds, padding and click event listeners
 *     decorate or add behavior to rows, text or buttons.
 */
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalStdlibApi
@InternalCoroutinesApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    savedStateHandle: SavedStateHandle? = null,

    ) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val scaffoldState = rememberScaffoldState()
    val resources = LocalContext.current.resources

    HomeContent(
        modifier = modifier,
        resources = resources,
        uiState = state,
        savedStateHandle = savedStateHandle,
        scaffoldState = scaffoldState,
        onBottomNavigationBarItemSelected = {
            viewModel.onBottomNavigationTabSelected(it)
            when (it.type) {
                is HomeBottomNavigationBarStateHolder.UiState.Tab.Type.Home -> {}
                is HomeBottomNavigationBarStateHolder.UiState.Tab.Type.Cases -> {}
                is HomeBottomNavigationBarStateHolder.UiState.Tab.Type.Profile -> {}
                is HomeBottomNavigationBarStateHolder.UiState.Tab.Type.HelpSupport -> {}
            }
        },
    )
}

/**
 * The private entry point to compose the home screen UI.
 *
 * @param modifier An ordered, immutable collection of modifier elements
 *     that decorate or add behavior to Compose UI elements. For
 *     example, backgrounds, padding and click event listeners
 *     decorate or add behavior to rows, text or buttons.
 */
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalStdlibApi
@InternalCoroutinesApi
@Composable
private fun HomeContent(
    modifier: Modifier = Modifier,
    resources: Resources,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    uiState: HomeViewModel.UiState,
    savedStateHandle: SavedStateHandle?,
    onBottomNavigationBarItemSelected: (HomeBottomNavigationBarStateHolder.UiState.Tab) -> Unit,
) {
    val menuVerticalOffset = remember { mutableStateOf(0) }

    AppScaffold(
        modifier = modifier
            .testTag(tag = HomeTestTags.SCREEN_ROOT),
        scaffoldState = scaffoldState,
        topBar = {
            AppTopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_splash_screen),
                            contentDescription = null
                        )
                    }
                },
                elevation = 0.dp
            )
        },
        bottomBar = {
            HomeBottomNavigation(
                state = { uiState.bottomNavigationBar },
                onBottomNavigationBarItemSelected = onBottomNavigationBarItemSelected,
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned {
                        // todo - is this actually needed
                        menuVerticalOffset.value = it.size.height
                    }
            )
        }
    ) { paddingValues ->
        Box {
            HomeNavigation(
                modifier = modifier.padding(paddingValues),
                selectedTab = { uiState.bottomNavigationBar.selectedTabType },
                savedStateHandle = savedStateHandle,
            )
            val snackBarState = uiState.network.errorSnackBar
            when {
                snackBarState != null -> LaunchedEffect(snackBarState) {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = snackBarState.message.asString(resources),
                        actionLabel = snackBarState.actionLabel.asString(resources),
                        duration = snackBarState.duration
                    )
                }
                // snackBar state is null, dismiss current snackBar
                else -> scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
            }
        }
    }
}

/**
 * The bottom navigation bar at the bottom of the home screen. This is
 * the component that controls the bottom nav item and screen displayed.
 *
 * @param modifier An ordered, immutable collection of modifier elements
 *     that decorate or add behavior to Compose UI elements. For
 *     example, backgrounds, padding and click event listeners
 *     decorate or add behavior to rows, text or buttons.
 * @param state
 * @param onBottomNavigationBarItemSelected A callback that will be
 *     invoked when a bottom navigation item is selected
 */
@Composable
private fun HomeBottomNavigation(
    modifier: Modifier = Modifier,
    state: () -> HomeBottomNavigationBarStateHolder.UiState?,
    onBottomNavigationBarItemSelected: (HomeBottomNavigationBarStateHolder.UiState.Tab) -> Unit
) {
    AppBottomNavigation(
        modifier = modifier.testTag(tag = HomeTestTags.HOME_BOTTOM_NAVIGATION)
    ) {
        state()?.tabs?.forEach { item ->
            val selected = state()?.selectedTabType == item.type
            AppBottomNavigationItem(
                modifier = Modifier
                    .testTag(tag = item.testTag),
                selected = selected,
                icon = {
                    AppBottomNavigationItemIcon(
                        selected = selected,
                        iconResId = item.iconResId,
                        hasNotifications = item.hasNotifications,
                        contentDescription = item.contentDescriptionResId?.let { stringResource(it) },
                    )
                },
                label = {
                    AppBottomNavigationItemText(
                        text = stringResource(item.labelResId),
                        color = if (selected) {
                            AppTheme.colors.primary
                        } else {
                            AppTheme.colors.colorControlNormal
                        }
                    )
                },
                onClick = { onBottomNavigationBarItemSelected(item) }
            )
        }
    }
}

/** A Compose preview of the screen built */
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalStdlibApi
@InternalCoroutinesApi
@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {
    HomeContent(
        resources = LocalContext.current.resources,
        uiState = HomeViewModel.UiState(
            bottomNavigationBar = HomeBottomNavigationBarStateHolder.UiState(
                selectedTabType = HomeBottomNavigationBarStateHolder.UiState.Tab.Type.Home,
                tabs = emptyList(),
            ),
            network = NetworkConnectivityStateHolder.UiState()
        ),
        savedStateHandle = SavedStateHandle(),
        onBottomNavigationBarItemSelected = {},
    )
}