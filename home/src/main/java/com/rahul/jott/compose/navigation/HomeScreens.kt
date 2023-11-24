package com.rahul.jott.compose.navigation

import com.rahul.jott.navigation.Screen
import com.rahul.jott.navigation.ScreenGraph
import com.rahul.jott.navigation.ScreenParams

object HomeScreens : ScreenGraph {
    override val route = "home"

    object Home : Screen {
        override val route = "home"

        /**
         * Home Parameter
         */
        object Params : ScreenParams {
            override fun screenName(): String? = null
            override fun screenProduct(): String? = null
            override fun createRoute(root: ScreenGraph) =
                "${root.route}/$route"
        }
    }
}
