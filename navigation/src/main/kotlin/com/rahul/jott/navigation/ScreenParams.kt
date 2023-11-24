package com.rahul.jott.navigation

/**
 * Generic interface to represent parameters required to navigate to a Screen
 *
 */
interface ScreenParams : AnalyticsScreen {
    /**
     * Creates a parameterized route for the associated screen
     *
     * @param root graph which is supplying this screen
     * @return route parameterized route
     *
     */
    fun createRoute(root: ScreenGraph): String
}
