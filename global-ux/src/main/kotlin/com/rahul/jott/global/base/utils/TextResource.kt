package com.rahul.jott.global.base.utils

import android.content.res.Resources
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

/**
 * An abstract implementation for resolving text from different Android implementations.
 * This implementation supports resolving text from a [String], a String resource id and from String plurals.
 *
 */
sealed class TextResource {
    /**
     * A class that models a simple [String] to display
     *
     * @property text The text to display
     */
    data class SimpleTextResource(
        val text: String
    ) : TextResource()

    /**
     * A class that models resolving a [String] id from from resources.
     *
     * @property id [String] id to resolve from resources
     * @property formatArgs The args to insert as the string place holder by order
     */
    data class IdTextResource(
        @StringRes val id: Int,
        val formatArgs: List<Any> = emptyList()
    ) : TextResource() {
        /**
         * needed to customize for Unit-Tests
         */
        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            if (javaClass != other?.javaClass) {
                return false
            }

            other as IdTextResource

            if (id != other.id) {
                return false
            }

            return true
        }

        override fun hashCode(): Int = id
    }

    /**
     * A class that models resolving a [String] plural id from from resources.
     *
     * @property pluralId The [String] plural id to resolve from resources
     * @property quantity The number used to get the correct string for the current language's plural rules.
     * @property formatArgs The args to insert as the string place holder by order
     */
    data class PluralTextResource(
        @PluralsRes val pluralId: Int,
        val quantity: Int,
        val formatArgs: List<Any>
    ) : TextResource() {
        /**
         * needed to customize for Unit-Tests
         */
        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            if (javaClass != other?.javaClass) {
                return false
            }

            other as PluralTextResource

            if (pluralId != other.pluralId) {
                return false
            }
            if (quantity != other.quantity) {
                return false
            }

            return true
        }

        override fun hashCode(): Int = 31 * pluralId + quantity
    }

    companion object {
        /**
         * A factory fun to create an instance of [TextResource]
         *
         * @param text The text to display
         * @return A [TextResource] implementation containing the [String] to display
         */
        fun fromText(text: String): TextResource = SimpleTextResource(text)

        /**
         * A factory fun to create an instance of [TextResource]
         *
         * @param id The [String] id to resolve from resources
         * @return A [TextResource] implementation containing the [String] id to resolve & display
         */
        fun fromStringId(
            @StringRes id: Int,
            formatArgs: List<Any> = emptyList()
        ): TextResource = IdTextResource(id, formatArgs)

        /**
         * A factory fun to create an instance of [TextResource]
         *
         * @param id The [String] id to resolve from resources
         * @param pluralValue The number used to get the correct string for the current language's plural rules.
         * @return * @return A [TextResource] implementation containing the [String] plural id to resolve & display
         */
        fun fromPlural(
            @PluralsRes id: Int,
            pluralValue: Int,
            formatArgs: List<Any>
        ): TextResource =
            PluralTextResource(id, pluralValue, formatArgs)
    }
}

/**
 * An extension fun that return a string from one of the supported [TextResource]'s sources.
 *
 * @param resources The [Resources] necessary to resolve string ids and string plurals
 * @return a String from one of these sources
 */
fun TextResource.asString(resources: Resources): String = when (this) {
    is TextResource.SimpleTextResource -> this.text
    is TextResource.IdTextResource -> resources.getString(this.id, *this.formatArgs.toTypedArray())
    is TextResource.PluralTextResource -> resources.getQuantityString(
        this.pluralId,
        this.quantity,
        *formatArgs.toTypedArray()
    )
}

/**
 * @return [TextResource] of a [String]
 */
fun String.asTextResource(): TextResource =
    TextResource.fromText(this)
