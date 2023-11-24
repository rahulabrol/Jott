package com.rahul.jott.navigation

import androidx.navigation.NavDeepLink
import androidx.navigation.navDeepLink
import com.rahul.jott.navigation.result.DeeplinkPairList
import com.rahul.jott.navigation.result.NavigationResult
import kotlin.reflect.KClass

typealias NavResultClass = KClass<out NavigationResult<*>>

/**
 * App wide screen supported by this controller
 *
 */
interface Screen {
    /**
     * the route for this screen.
     */
    val route: String

    /**
     * reference to implementation of NavResultClass specifying supported ResultData
     * this screen may return
     */
    val returns: NavResultClass?
        get() = null

    /**
     * The support deeplink routes for this screen
     */
    val deeplinkRoutes: List<String>
        get() = emptyList()

    /**
     * These params are required when user is opening application  from deeplink
     * and this will used to fire the impression for any screen adding an example on how to use it
     * This will identify which deeplink user is coming from and do we need to fire the
     * impression In this case we use [Pair] to map keys and values like product tells where user
     * should route to and action defines which screen user wants to navigate and both are required
     * params.
     * [deeplinkRoutes] defines which params we are expecting from a particular deeplink but
     * [requiredDeeplinkPairs] help us to identify product and screen for which we wants to fire
     * the impression.
     *
     * Example is:
     *
     *  override val requiredDeeplinkPairs: DeeplinkPairList = listOf(
     *      Pair(DeepLinkKeys.PRODUCT, PRODUCT),
     *      Pair(DeepLinkKeys.ACTION, ACTION_RESULTS),
     *      )
     *
     */
    val requiredDeeplinkPairs: DeeplinkPairList
        get() = emptyList()

    /**
     * Deep link keys
     *
     * @constructor Create empty Deep link keys
     */
    object DeepLinkKeys {
        const val PRODUCT = "product"
        const val ACTION = "action"
        const val KEY_DEEPLINK_PICK_UP_DATE_TIME = "pickupDateTime"
        const val KEY_DEEPLINK_DROP_OFF_DATE_TIME = "dropoffDateTime"
        const val KEY_DEEPLINK_PICK_UP_DESTINATION_ID = "pickupAirport"
        const val KEY_DEEPLINK_DROP_OFF_DESTINATION_ID = "dropoffAirport"
    }

    /**
     * Return supported deeplink routes fully qualified with base url
     *
     * @return list of NavDeeplinks for JetPack Compose Navigation Integration
     */
    fun deeplinks(): List<NavDeepLink> = deeplinkRoutes.map { route ->
        navDeepLink { uriPattern = ("$BASE_URL$route") }
    }

    companion object {
        const val BASE_URL = "www.priceline.com/r/app/"
    }
}
