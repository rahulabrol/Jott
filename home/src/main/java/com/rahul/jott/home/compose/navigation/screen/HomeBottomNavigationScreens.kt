package com.rahul.jott.home.compose.navigation.screen

import com.rahul.jott.global.navigation.ProductNavigationKey.KEY_SELECTED_PRODUCT
import com.rahul.jott.navigation.Screen
import com.rahul.jott.navigation.ScreenGraph

object HomeBottomNavigationScreens : ScreenGraph {
    override val route = "home_internal"

    object Book : Screen {
        override val route = "home_book?product={$KEY_SELECTED_PRODUCT}"
//        override val deeplinkRoutes =
//            HotelScreens.BookHotelScreen.deeplinkRoutes +
//                CarScreens.BookCarScreen.deeplinkRoutes +
//                AirScreens.BookAirScreen.deeplinkRoutes
    }
}
