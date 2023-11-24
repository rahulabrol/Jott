package com.rahul.jott.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Sealed class that encapsulates the results returned back from a destination screen
 * Ensures type-safety when consuming Navigation Results
 * CRITICAL: ONLY ADD IMPLEMENTATIONS SUPPORTED BY SAVED STATE HANDLE!!
 * https://developer.android.com/topic/libraries/architecture/viewmodel-savedstate#types
 */
sealed interface NavigationData : Parcelable {
    /**
     * The result data, must be one of the supported types by Android Navigation
     */
    val data: Any

    /**
     * Encapsulates string results
     *
     * @property data
     */
    @Parcelize
    data class StringData(override val data: String) : NavigationData

    /**
     * Encapsulates parcelable results
     *
     * @property data
     */
    @Parcelize
    data class ParceledData<T : Parcelable>(override val data: T) : NavigationData

    companion object {
        /**
         * Get proper navigation result wrapper for a given data type
         *
         * @param data data to wrap, must be a supported Saved State Handle data type
         * @return NavigationData wrapper
         */
        fun from(data: Any): NavigationData =
            when (data) {
                is String -> StringData(data)
                is Parcelable -> ParceledData(data)
                else -> throw IllegalArgumentException("data not supported: $data")
            }
    }
}
