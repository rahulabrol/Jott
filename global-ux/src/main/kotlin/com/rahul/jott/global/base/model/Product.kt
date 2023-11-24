package com.rahul.jott.global.base.model

private const val FLIGHT_ID = 1
private const val FLIGHT_NAV_ARG = "air"
private const val HOTEL_ID = 5
private const val HOTEL_NAV_ARG = "hotel"
private const val RENTAL_CAR_ID = 8
private const val RENTAL_CAR_NAV_ARG = "rc"

/**
 * Represents Products supported within the Priceline application ecosystem
 *
 * @property id - Priceline's unique identifier associated with the product
 * @property navValue string value for product in deeplinks
 */
enum class Product(val id: Int, val navValue: String) {
    FLIGHT(FLIGHT_ID, FLIGHT_NAV_ARG),
    HOTEL(HOTEL_ID, HOTEL_NAV_ARG),
    RENTAL_CAR(RENTAL_CAR_ID, RENTAL_CAR_NAV_ARG),
    ;

    companion object {
        /**
         * Get value using id
         *
         * @param value
         * @return Product
         */
        fun fromId(value: Int?) = values().firstOrNull { it.id == value } ?: HOTEL

        /**
         * Get value using deeplink string value
         *
         * @param value
         * @return Product
         */
        fun fromNavArgumentValue(value: String) = values().firstOrNull {
            it.navValue == value
        }
    }
}
