package com.rahul.jott.navigation.result

import com.rahul.jott.navigation.NavigationData

typealias NavigationObjectResult<T> = NavigationResult<NavigationData.ParceledData<T>>

/**
 * Interface to represent interactions that pass data from destination screen to entry screen within the application
 *
 * @param T specifies the data type expected from destination screen
 */
interface NavigationResult<in T : NavigationData> {
    /**
     * This will be a unique key to represent a single piece of data to be passed from one screen to another
     */
    val id: String

    companion object {
        const val KEY_RESULT: String = "KEY_RESULT"
    }
}
