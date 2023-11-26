package com.rahul.jott.android.networking

import kotlinx.coroutines.flow.Flow

/**
 * Network connectivity
 *
 * @constructor Create empty Network connectivity
 */
interface NetworkConnectivity {
    /**
     * Network state presented as a flow for easy consumption
     * of required knowledge of the network state
     */
    val state: Flow<Network.State>
}
