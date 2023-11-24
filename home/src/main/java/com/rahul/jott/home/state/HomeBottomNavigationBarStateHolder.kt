package com.rahul.jott.home.state

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rahul.jott.R
import com.rahul.jott.global.base.state.StateHolder2
import com.rahul.jott.home.compose.navigation.screen.HomeBottomNavigationScreens
import com.rahul.jott.home.state.HomeBottomNavigationBarStateHolder.UiState
import com.rahul.jott.home.state.HomeBottomNavigationBarStateHolder.UiState.Tab
import com.rahul.jott.home.util.HomeTestTags
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

/**
 * A class responsible for generating state for UI components.
 * It can represent a screen or parts of it.
 *
 * In this case, this class is responsible for representing the state of the home
 * bottom navigation bar.
 */
class HomeBottomNavigationBarStateHolder @Inject constructor(
//    private val gaUseCase: GoogleAnalyticsUseCase,
//    notificationCompat: NotificationCompat,
) : StateHolder2<Unit, UiState>() {
    override val params = Unit
    override val initialState: UiState = UiState(
        selectedTabType = Tab.Type.Home,
        tabs = initialState(
            selectedTab = Tab.Type.Home
        )
    )
    private val _state: MutableStateFlow<UiState> = MutableStateFlow(
        initialState
    )
    override val state: Flow<UiState> = _state.onStart {
        UiState(
            selectedTabType = Tab.Type.Home,
            tabs = listOf(
                homeBottomNavigationItem(selectedScreen = _state.value.selectedTabType),
                myCasesTab(
                    selectedTabType = _state.value.selectedTabType
                ),
                profileTab(
                    selectedTabType = _state.value.selectedTabType
                ),
                helpSupportTab(selectedTabType = _state.value.selectedTabType)
            )
        )
    }

    /**
     * Generate the list representing the list of bottom navigation bar items
     *
     * @param selectedTab The screen to be displayed.
     * @return A list of the home bottom navigation bar items.
     */
    private fun initialState(selectedTab: Tab.Type) =
        listOf(
            homeBottomNavigationItem(selectedScreen = selectedTab),
            myCasesTab(selectedTabType = selectedTab),
            profileTab(selectedTabType = selectedTab),
            helpSupportTab(selectedTabType = selectedTab)
        )

    private fun homeBottomNavigationItem(
        selectedScreen: Tab.Type,
    ) = Tab(
        type = Tab.Type.Home,
        labelResId = R.string.home,
        contentDescriptionResId = R.string.home,
        iconResId = R.drawable.ic_book,
        selected = selectedScreen == Tab.Type.Home,
        testTag = HomeTestTags.HOME_BOTTOM_NAVIGATION_ITEM_BOOK
    )

    private fun myCasesTab(
        selectedTabType: Tab.Type,
    ) = Tab(
        type = Tab.Type.Cases,
        labelResId = R.string.cases,
        contentDescriptionResId = R.string.cases,
        iconResId = R.drawable.ic_mytrips,
        selected = selectedTabType == Tab.Type.Cases,
        testTag = HomeTestTags.HOME_BOTTOM_NAVIGATION_ITEM_MY_TRIPS
    )

    private fun profileTab(
        selectedTabType: Tab.Type,
        hasUnreadNotifications: Boolean = false,
    ) = Tab(
        type = Tab.Type.Profile,
        labelResId = R.string.profile,
        contentDescriptionResId = R.string.profile,
        iconResId = R.drawable.ic_notifications,
        selected = selectedTabType == Tab.Type.Profile,
        testTag = HomeTestTags.HOME_BOTTOM_NAVIGATION_ITEM_NOTIFICATIONS,
        hasNotifications = hasUnreadNotifications
    )

    private fun helpSupportTab(
        selectedTabType: Tab.Type,
    ) = Tab(
        type = Tab.Type.HelpSupport,
        labelResId = R.string.help,
        contentDescriptionResId = R.string.help,
        iconResId = R.drawable.ic_more,
        selected = selectedTabType == Tab.Type.HelpSupport,
        testTag = HomeTestTags.HOME_BOTTOM_NAVIGATION_ITEM_MORE
    )

    /**
     * @property selectedTabType
     * @property tabs
     */
    data class UiState(
        val selectedTabType: Tab.Type,
        val tabs: List<Tab>
    ) {
        /**
         * A model data class that represents a single bottom navigation item.
         *
         * @property type The screen that the item/tab represents
         * @property iconResId The icon resource id to be displayed in the bottom navigation item
         * @property labelResId The text resource id to be displayed under the icon in a bottom navigation item
         * @property contentDescriptionResId The content description resource id to be describe the icon,
         *                                   or null if one isn't needed.
         * @property selected
         * @property testTag
         * @property hasNotifications
         */
        data class Tab(
            val type: Type,
            @DrawableRes val iconResId: Int,
            val selected: Boolean,
            @StringRes val labelResId: Int,
            @StringRes val contentDescriptionResId: Int?,
            val testTag: String,
            var hasNotifications: Boolean = false
        ) {
            /**
             * Represents the home experience internal screens
             *
             * @property route
             */
            sealed class Type(val route: String? = null) {
                object Home : Type(
                    route = HomeBottomNavigationScreens.createRoute(
                        screen = HomeBottomNavigationScreens.Book
                    )
                )

                object Cases : Type()
                object Profile : Type()
                object HelpSupport : Type()
            }
        }
    }
}
