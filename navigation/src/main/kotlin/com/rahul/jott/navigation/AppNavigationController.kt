package com.rahul.jott.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.core.net.toUri
import androidx.lifecycle.Lifecycle
import androidx.navigation.*
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedComposeNavigator
import com.rahul.jott.navigation.result.NavigationResult

private const val ANALYTICS_SCREEN_NAME = "ANALYTICS_SCREEN_NAME"
private const val ANALYTICS_SCREEN_PRODUCT = "ANALYTICS_SCREEN_PRODUCT"

/**
 * Wraps a NavController, which offers additional APIs for use by a NavHost to connect the NavController
 * to external dependencies.
 * Apps should generally not construct controllers, instead obtain a relevant controller directly
 * from a navigation host via NavHost.getNavController or by using one of the utility methods on the
 * Navigation class.
 *
 * @property _controller
 */
data class AppNavigationController(
    private val _controller: NavHostController
) {
    /**
     * @return the wrapped [NavHostController]
     */
    internal fun asNavHostController() = _controller
}

/**
 * Extension function to generically support "Screen Result." This aligns with the
 * Android Activity and Fragment result contracts.  When invoked his will accept supported data, set it
 * as an argument to the saveStateHandle for the prior backstack entry, and navigate back from
 * the current screen.
 *
 * @param backStackEntry entry for the Screen providing results.  This screen must have a KEY_RESULT
 * as part of its navigation parameters, to specify a unique identifier used to identify the data
 * it returns
 * @param navigationData data being passed to the prior Screen
 */
fun AppNavigationController.setNavigationResultFromArgument(
    backStackEntry: NavBackStackEntry,
    navigationData: NavigationData,
    key: String = NavigationResult.KEY_RESULT
) {
    backStackEntry.arguments?.getString(key)?.let { resultKey ->
        setNavigationResult(
            navigationData = navigationData,
            resultKey = resultKey
        )
    }
}

/**
 * Extension function to generically support "Screen Result." This aligns with the
 * Android Activity and Fragment result contracts.  When invoked his will accept supported data only
 *
 * @param navigationData data being passed to the prior Screen
 * @param resultKey specifies key utilized to save data in SaveStateEntry
 */
fun AppNavigationController.setNavigationResult(
    navigationData: NavigationData,
    resultKey: String
) {
    asNavHostController().previousBackStackEntry?.savedStateHandle?.set(
        key = resultKey,
        value = NavigationData.from(navigationData.data)
    )
}

/**
 * Extension function to generically provide the ability to open
 * Android System Settings for Priceline app
 *
 */
fun AppNavigationController.openSystemSettings() = asNavHostController().openSystemSettings()

/**
 * Extension function to generically provide the ability to
 * send sms to Priceline
 *
 */
fun AppNavigationController.sendMessage(
    number: String,
    message: String? = null,
) = asNavHostController().sendMessage(
    number = number,
    message = message
)

/**
 * Navigate to a Screen
 * Supports navigating to a route the current Nav Graph or navigating to a Legacy Screen
 *
 * @param root
 * @param params
 */
fun AppNavigationController.navigate(
    root: ScreenGraph,
    params: ScreenParams
) {
    val uri = NavDestination.createRoute(params.createRoute(root))
        .toUri()
        .buildUpon()
        .build()

    asNavHostController().navigate(uri)
}

/**
 * Attempts to pop the controller's back stack. Analogous to when the user presses the system Back
 * button when the associated navigation host has focus.
 *
 * @return true if the stack was popped at least once and the user has been navigated
 * to another destination, false otherwise
 */
fun AppNavigationController.popBackStack() {
    when (asNavHostController().currentBackStackEntry?.lifecycle?.currentState) {
        Lifecycle.State.RESUMED -> {
            asNavHostController().popBackStack()
        }

        Lifecycle.State.DESTROYED,
        Lifecycle.State.INITIALIZED,
        Lifecycle.State.CREATED,
        Lifecycle.State.STARTED,
        null -> {
        } // no-op, not valid state to pop back stack
        else -> {}
    }
}

/**
 * @return The SavedStateHandle for the current backstack entry
 */
fun AppNavigationController.currentSaveStateHandle() =
    asNavHostController().currentBackStackEntry?.savedStateHandle

/**
 * The current destination.
 */
fun AppNavigationController.currentDestination() = asNavHostController().currentDestination

/**
 * Attempts to navigate up in the navigation hierarchy. Suitable for when the
 * user presses the "Up" button marked with a left (or start)-facing arrow in the upper left
 * (or starting) corner of the app UI.
 *
 * The intended behavior of Up differs from [Back][popBackStack] when the user
 * did not reach the current destination from the application's own task. e.g. if the user
 * is viewing a document or link in the current app in an activity hosted on another app's
 * task where the user clicked the link. In this case the current activity (determined by the
 * context used to create this NavController) will be [finished][Activity.finish] and
 * the user will be taken to an appropriate destination in this app on its own task.
 *
 * @return true if navigation was successful, false otherwise
 */
fun AppNavigationController.navigateUp() = asNavHostController().navigateUp()

private fun NavController.openSystemSettings() {
    val context = this.context
    context.launchActivity {
        apply {
            action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS.apply {
                data = Uri.fromParts("package", context.packageName, null)
            }
        }
    }
}

private fun NavController.sendMessage(
    number: String,
    message: String? = null,
) {
    val context = this.context
    context.launchActivity {
        apply {
            action = Intent.ACTION_SENDTO.apply {
                data = Uri.parse("smsto:$number")
                message?.let {
                    putExtra("sms_body", it)
                }
            }
        }
    }
}

private fun Context.launchActivity(
    bundle: Bundle? = null,
    launch: Intent.() -> Unit
) = this.startActivity(Intent().apply(launch), bundle)

/**
 * Creates a [AppNavigationController] wrapping a NavHostController that handles the adding of the
 * [ComposeNavigator] and [DialogNavigator]. Additional [Navigator] instances can be passed through
 * [navigators] to be applied to the returned NavController. Note that each [Navigator] must be separately
 * remembered before being passed in here: any changes to those inputs will cause the
 * NavController to be recreated.
 *
 * @param navigators
 * @return the AppNavigationController
 *
 * @see NavHost
 */
@ExperimentalAnimationApi
@Composable
fun rememberAppAnimatedNavController(
    vararg navigators: Navigator<out NavDestination>,
): AppNavigationController {
    val animatedNavigator = remember { AnimatedComposeNavigator() }
    return AppNavigationController(
        rememberNavController(animatedNavigator, *navigators),
    )
}
