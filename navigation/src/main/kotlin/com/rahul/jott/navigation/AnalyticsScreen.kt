package com.rahul.jott.navigation

/**
 * Provides a Screen related data to send to Analytics engines
 */
interface AnalyticsScreen {
    /**
     * @return Screen name. If null the screen is not sent to Analytics
     */
    fun screenName(): String?

    /**
     * @return Screen product. If null the screen is not sent to Analytics
     */
    fun screenProduct(): String?
}
