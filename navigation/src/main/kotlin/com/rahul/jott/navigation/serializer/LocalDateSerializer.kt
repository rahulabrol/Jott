package com.rahul.jott.navigation.serializer

//import com.priceline.android.date.time.utils.FORMAT_MM_dd_yyyy
//import com.priceline.android.date.time.utils.toFormattedString
import com.rahul.jott.navigation.NavigationParamSerializer
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * format date month/day/year. Eg. 01/01/2022, 12/31/2022
 */
const val FORMAT_MM_dd_yyyy = "MM/dd/yyyy"

/**
 * A Utility fun to format a [LocalDate] as a string
 *
 * @param format The format to apply on the [LocalDate]. Should confirm with [DateTimeFormatter]
 * @return The formatted [LocalDate] string
 */
fun LocalDate.toFormattedString(format: String): String =
    this.format(DateTimeFormatter.ofPattern(format, Locale.getDefault()))


object LocalDateSerializer : NavigationParamSerializer<LocalDate> {
    private const val SERIALIZATION_PATTERN = FORMAT_MM_dd_yyyy

    override fun serialize(value: LocalDate?) = serialize(value, SERIALIZATION_PATTERN)

    override fun deserialize(bundledValue: String?) =
        deserialize(bundledValue, SERIALIZATION_PATTERN)

    /**
     * Serialize with specific Date Serialization Pattern
     *
     * @param value
     * @param pattern
     * @return string representation
     */
    fun serialize(value: LocalDate?, pattern: String) = value?.toFormattedString(pattern)

    /**
     * Deserialize from string with specific Date Serialization Pattern
     *
     * @param bundledValue
     * @param pattern
     * @return LocalDate
     */
    fun deserialize(bundledValue: String?, pattern: String) =
        bundledValue?.let { stringDate ->
            kotlin.runCatching {
                LocalDate.from(
                    DateTimeFormatter.ofPattern(pattern)
                        .parse(stringDate)
                )
            }
        }?.getOrNull()
}
