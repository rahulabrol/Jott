package com.rahul.jott.navigation.serializer

import com.rahul.jott.navigation.NavigationParamSerializer
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * format date time Eg: [20200710-14:00]
 */
const val FORMAT_yyyyMMdd_HHmm = "yyyyMMdd-HH:mm"

/**
 * A Utility fun to format a [ZonedDateTime] as a string
 *
 * @param format The format to apply on the [ZonedDateTime]. Should confirm with [DateTimeFormatter]
 * @return The formatted [ZonedDateTime] string
 */
fun ZonedDateTime.toFormattedString(format: String): String =
    this.format(DateTimeFormatter.ofPattern(format, Locale.getDefault()))

object ZonedDateTimeSerializer : NavigationParamSerializer<ZonedDateTime> {
    private const val DEFAULT_SERIALIZATION_PATTERN = FORMAT_yyyyMMdd_HHmm

    override fun serialize(value: ZonedDateTime?) = value?.toFormattedString(
        DEFAULT_SERIALIZATION_PATTERN
    )

    override fun deserialize(bundledValue: String?): ZonedDateTime? =
        bundledValue?.let { stringDate ->
            kotlin.runCatching {
                ZonedDateTime.of(
                    LocalDateTime.from(
                        DateTimeFormatter.ofPattern(DEFAULT_SERIALIZATION_PATTERN)
                            .parse(stringDate)
                    ),
                    ZoneId.systemDefault()
                )
            }
        }?.getOrNull()
}
