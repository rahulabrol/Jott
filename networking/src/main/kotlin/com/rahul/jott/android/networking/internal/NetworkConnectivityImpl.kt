package com.rahul.jott.android.networking.internal

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.core.content.ContextCompat
import com.rahul.jott.android.networking.Network.State
import com.rahul.jott.android.networking.NetworkConnectivity
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

/**
 * Implementation of NetworkConnectivity
 *
 * @param context
 */
@Suppress("MissingPermission")
class NetworkConnectivityImpl @Inject constructor(
    @ApplicationContext context: Context
) : NetworkConnectivity {
    override val state = callbackFlow {
        val connectivityManager =
            ContextCompat.getSystemService(
                context,
                ConnectivityManager::class.java
            ) as ConnectivityManager

        val networkCallback = object :
            ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                trySend(State.Connected)
            }

            override fun onLost(network: Network) {
                trySend(State.Disconnected)
            }

            override fun onUnavailable() {
                trySend(State.Disconnected)
            }
        }
        trySend(State.Disconnected)

        connectivityManager.registerDefaultNetworkCallback(networkCallback)

        awaitClose {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        }
    }
}
