package com.rahul.jott.home.state

import androidx.compose.material.SnackbarDuration
import com.rahul.jott.android.networking.Network
import com.rahul.jott.android.networking.NetworkConnectivity
import com.rahul.jott.global.R
import com.rahul.jott.global.base.state.StateHolder2
import com.rahul.jott.global.base.utils.TextResource
import com.rahul.jott.global.snackbar.SnackBarUiState
import com.rahul.jott.home.util.launchFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Network Connectivity state holder class
 *
 * @param networkConnectivity
 */
class NetworkConnectivityStateHolder @Inject constructor(
    private val networkConnectivity: NetworkConnectivity,
) : StateHolder2<Unit, NetworkConnectivityStateHolder.UiState>() {
    override val params = Unit
    override val initialState: UiState = UiState()
    private val _state = MutableStateFlow(InternalState())

    override val state: Flow<UiState> = combine(_state, networkState()) { internal, _ ->
        UiState(
            errorSnackBar = SnackBarUiState(
                message = TextResource.fromStringId(R.string.no_network),
                actionLabel = TextResource.fromStringId(R.string.dismiss),
                duration = SnackbarDuration.Indefinite
            ).takeIf {
                internal.show
            }
        )
    }

    private fun networkState() = launchFlow {
        networkConnectivity.state.collect { networkState ->
            if (networkState is Network.State.Disconnected && !_state.value.hasShown) {
                _state.update {
                    it.copy(
                        hasShown = true,
                        show = true
                    )
                }
            } else if (networkState is Network.State.Connected) {
                _state.update {
                    it.copy(
                        hasShown = false,
                        show = false
                    )
                }
            }
        }
    }

    /**
     * Internal Network Connectivity State
     *
     * @property show
     * @property hasShown
     */
    data class InternalState(
        val show: Boolean = false,
        val hasShown: Boolean = false
    )

    /**
     * Ui State to show network error
     *
     * @property errorSnackBar
     */
    data class UiState(
        val errorSnackBar: SnackBarUiState? = null
    )
}
