package com.rahul.jott.navigation

/**
 * App wide navigation graph supported by this controller
 * Represents supported screens within a UI intgration module
 *
 */
interface ScreenGraph {
    /**
     * Route for this screen graph
     */
    val route: String

    /**
     * Creates a unique route for every destination
     *
     * @param screen the screen for the destination
     * @return the unique route for this destination
     */
    fun createRoute(screen: Screen) = "$route/${screen.route}"
}
