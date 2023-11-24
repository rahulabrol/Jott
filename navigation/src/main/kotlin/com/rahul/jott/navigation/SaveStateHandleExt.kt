package com.rahul.jott.navigation

import androidx.lifecycle.SavedStateHandle

/**
 * Shorthand for getting strings from bundle
 *
 * @return argument as String
 */
fun SavedStateHandle.value(key: String) = get<String>(key)
