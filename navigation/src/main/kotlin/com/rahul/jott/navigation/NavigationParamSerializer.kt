package com.rahul.jott.navigation

/**
 * Interface for defining how an individual Navigation Parameter type should be serialized to a String
 * and deserialized back to the typed class (nullably)
 *
 * @param T Data type for the navigation argument
 */
internal interface NavigationParamSerializer<T> {
    /**
     * Serialize a data value to compose route representation
     *
     * @param value data to be serialized
     * @return string representation of this value
     */
    fun serialize(value: T?): String?

    /**
     * Deserialize compose route representation to optional data value
     *
     * @param bundledValue the compose argument data as string
     * @return data value held in navigation for this Navigation Parameter
     */
    fun deserialize(bundledValue: String?): T?
}
