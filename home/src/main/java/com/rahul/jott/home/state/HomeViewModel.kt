package com.rahul.jott.home.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/** The home screen state holder. */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bottomNavigationBarState: HomeBottomNavigationBarStateHolder,
    private val networkConnectivityStateHolder: NetworkConnectivityStateHolder
) : ViewModel() {
    /**
     * A state flow representing the screen ui state.
     */
    internal val state: StateFlow<UiState> = combine(
        bottomNavigationBarState.state,
        networkConnectivityStateHolder.state
    ) { bottomNavigationBar,
        networkConnectivityState ->
        UiState(
            bottomNavigationBar = bottomNavigationBar,
            network = networkConnectivityState
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = initialState(),
    )

    private fun initialState() = UiState(
        bottomNavigationBar = bottomNavigationBarState.initialState,
        network = networkConnectivityStateHolder.initialState,
    )

    fun onBottomNavigationTabSelected(it: HomeBottomNavigationBarStateHolder.UiState.Tab) {
        println(it)
    }

    /**
     * An interface representing an the UI state. Common states are loading,
     * error and of course the data representing the UI
     * @property bottomNavigationBar
     * @property network
     */
    internal data class UiState(
        val bottomNavigationBar: HomeBottomNavigationBarStateHolder.UiState,
        val network: NetworkConnectivityStateHolder.UiState
    )
}
