package com.rahul.jott.home.compose.navigation

import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.rahul.jott.home.compose.navigation.screen.HomeBottomNavigationScreens
import com.rahul.jott.home.state.HomeBottomNavigationBarStateHolder
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * The home screen composable the is in charge of handling internal navigation
 * within the home screen.
 *
 * @param modifier An ordered, immutable collection of modifier elements that decorate or add behavior
 *                 to Compose UI elements. For example, backgrounds, padding and click event listeners
 *                 decorate or add behavior to rows, text or buttons.
 */
@OptIn(ExperimentalAnimationApi::class)
@ExperimentalMaterialApi
@ExperimentalStdlibApi
@InternalCoroutinesApi
@Composable
internal fun HomeNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    savedStateHandle: SavedStateHandle?,
    selectedTab: () -> HomeBottomNavigationBarStateHolder.UiState.Tab.Type?,
) {
    NavHost(
        navController = navController,
        startDestination = HomeBottomNavigationScreens.createRoute(HomeBottomNavigationScreens.Book),
    ) {
        composable(
            route = HomeBottomNavigationScreens.createRoute(HomeBottomNavigationScreens.Book),
            deepLinks = HomeBottomNavigationScreens.Book.deeplinks()
        ) {
            println(modifier)
            println(savedStateHandle)
//            BookScreen(
//                modifier = modifier,
//                savedStateHandle = savedStateHandle,
//            )
        }
    }

    selectedTab()?.route?.let { route ->
        if (navController.currentDestination?.route != route) {
            navController.navigate(route)
        }
    }
}
