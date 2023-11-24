package com.rahul.jott.compose.navigation.graph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.rahul.jott.compose.navigation.HomeScreens
import com.rahul.jott.home.compose.HomeScreen
import com.rahul.jott.navigation.AppNavigationController
import com.rahul.jott.navigation.ScreenGraph
import com.rahul.jott.navigation.currentSaveStateHandle
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * Created by abrol at 23/11/23.
 */

@ExperimentalMaterialApi
@OptIn(ExperimentalStdlibApi::class)
@InternalCoroutinesApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addHomeGraph(
    navController: AppNavigationController,
) {
    val rootScreen = HomeScreens
    navigation(
        route = rootScreen.route,
        startDestination = rootScreen.createRoute(HomeScreens.Home),
    ) {
        HomeDestination(
            navController,
            rootScreen
        )
    }
}

@ExperimentalMaterialApi
@ExperimentalStdlibApi
@InternalCoroutinesApi
@ExperimentalAnimationApi
internal fun NavGraphBuilder.HomeDestination(
    navController: AppNavigationController,
    root: ScreenGraph,
) {
    composable(
        route = root.createRoute(HomeScreens.Home),
        deepLinks = HomeScreens.Home.deeplinks()
    ) {
        HomeScreen(
            savedStateHandle = navController.currentSaveStateHandle(),
        )
    }
}