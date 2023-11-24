package com.rahul.jott.navigation.result

import com.rahul.jott.navigation.NavigationData


/**
 * @property navigationResult
 * @property handleResult
 */
data class SavedStateDataHandler<T : NavigationData>(
    val navigationResult: NavigationResult<T>,
    val handleResult: (T) -> Unit
)
