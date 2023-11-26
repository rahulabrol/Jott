package com.rahul.jott.android.networking

/**
 * Network config
 *
 * @constructor Create empty Network config
 */
interface NetworkConfig {
    /**
     * @return referralId
     */
    fun referralId(): String

    /**
     * @return Referral source id
     */
    fun referralSourceId(): String

    /**
     * @return ClientSessionId is unique per app session
     */
    fun clientSessionId(): String

    /**
     * @return Request id
     */
    fun requestId(): String

    /**
     * Header
     *
     * @return header
     */
    fun generateSearchHeader(pageName: String, searchType: String): Map<String, String>

    companion object {
        const val QUALIFIER_FLIGHT = "QUALIFIER_FLIGHT"
        const val QUALIFIER_HOTEL = "QUALIFIER_HOTEL"
        const val SEARCH_HEADER = "x-pcln-search-source"
        const val KEY_SEARCH_TYPE = "-searchtype:"
        const val KEY_PAGE_NAME = "appname:AndroidApp-pagename:"
    }
}
