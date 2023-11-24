package com.rahul.jott.navigation

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * A fun to get the activity from a a given [Context]
 * This should be used with 'LocalContext.current' or fragment/view context.
 * This won't work with application context
 *
 * @return The activity from [Context]
 * @throws IllegalStateException If the activity can't be found
 */
fun Context.findActivity(): AppCompatActivity {
    var context = this
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    throw IllegalStateException("PreferenceCenter should be called in the context of an AppCompatActivity")
}

/**
 * @return the default enter animation transition
 */
@ExperimentalAnimationApi
internal fun AnimatedContentScope<*>.defaultEnterTransition() =
    slideIntoContainer(AnimatedContentScope.SlideDirection.Start)

/**
 * @return the default exit animation transition
 */
@ExperimentalAnimationApi
internal fun AnimatedContentScope<*>.defaultExitTransition() =
    slideOutOfContainer(AnimatedContentScope.SlideDirection.Start)

/**
 * @return the default pop enter animation transition
 */
@ExperimentalAnimationApi
internal fun AnimatedContentScope<*>.defaultPopEnterTransition() =
    slideIntoContainer(AnimatedContentScope.SlideDirection.End)

/**
 * @return the default pop exit animation transition
 */
@ExperimentalAnimationApi
internal fun AnimatedContentScope<*>.defaultPopExitTransition() =
    slideOutOfContainer(AnimatedContentScope.SlideDirection.End)

/**
 * The navigation controller for app wide navigation graphs and destinations.
 *
 * @param modifier An ordered, immutable collection of modifier elements that decorate or add behavior to
 *                 Compose UI elements.
 *                 For example, backgrounds, padding and click event listeners decorate or add behavior to
 *                 rows, text or buttons.
 * @param navController the navController for this host
 */
@InternalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun AppNavigationHost(
    modifier: Modifier = Modifier,
    navController: AppNavigationController,
    startDestination: String,
    builder: NavGraphBuilder.() -> Unit
) {
    AnimatedNavHost(
        navController = navController.asNavHostController(),
        startDestination = startDestination,
        enterTransition = { defaultEnterTransition() },
        exitTransition = { defaultExitTransition() },
        popEnterTransition = { defaultPopEnterTransition() },
        popExitTransition = { defaultPopExitTransition() },
        modifier = modifier,
        builder = builder
    )
}
