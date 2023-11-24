package com.rahul.jott.global.base.utils

import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * THis class is used for string,img and drawable resources
 *
 * @property context
 */
class ResourcesProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {
    /**
     * used for getting string from resources
     *
     * @param stringResId
     * @param formatArgs
     * @return String
     */
    fun asString(@StringRes stringResId: Int, formatArgs: List<Any> = emptyList()): String = context.resources.getString(stringResId, *formatArgs.toTypedArray())

    /**
     * used for getting string from plural resources
     *
     * @param pluralId
     * @param quantity
     * @param formatArgs
     * @return String
     */
    fun asQuantityString(
        @PluralsRes pluralId: Int,
        quantity: Int = 0,
        formatArgs: List<Any> = emptyList()
    ): String = context.resources.getQuantityString(pluralId, quantity, *formatArgs.toTypedArray())
}
