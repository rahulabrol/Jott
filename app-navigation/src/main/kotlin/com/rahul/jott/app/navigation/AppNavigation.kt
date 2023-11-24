package com.rahul.jott.app.navigation

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.rahul.jott.compose.navigation.HomeScreens
import com.rahul.jott.compose.navigation.graph.addHomeGraph
import com.rahul.jott.navigation.AppNavigationController
import com.rahul.jott.navigation.AppNavigationHost
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * The navigation controller for app wide navigation graphs and destinations.
 *
 * @param modifier
 * @param navController
 * @param deeplinkUrl
 * @param launchDeeplinkUri
 * @param launchPhoneDialer
 * @receiver trigger deeplink
 * @receiver open phone dialer
 */
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@InternalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier.semantics {
        testTagsAsResourceId = true
    },
    navController: AppNavigationController,
    deeplinkUrl: String?,
    launchDeeplinkUri: (Uri) -> Unit,
) {
    println(deeplinkUrl)
    println(launchDeeplinkUri)

    AppNavigationHost(
        modifier = modifier,
        navController = navController,
        startDestination = HomeScreens.route,
    ) {
        addHomeGraph(
            navController = navController,
        )
    }
}
