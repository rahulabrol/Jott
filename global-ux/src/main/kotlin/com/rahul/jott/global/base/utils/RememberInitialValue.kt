package com.rahul.jott.global.base.utils

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import kotlinx.coroutines.flow.Flow

/**
 * A Compose State representing the first emission from a flow, null prior to initial emission
 *
 * @param T The flow type
 * @param flow to remember with the lifecycle provided
 * @param lifecycle The Lifecycle where the restarting collecting from this flow work will be kept alive.
 * @param minActiveState Lifecycle.State in which the upstream flow gets collected.
 *                        The collection will stop if the lifecycle falls below that state,
 *                        and will restart if it's in that state again
 * @return Compose State that will be either null or the first value retreived from Flow
 */
@Composable
fun <T> rememberInitialValueWithLifecycle(
    flow: Flow<T>,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): State<T?> {
    val state = rememberFlowWithLifecycle(
        flow = flow,
        lifecycle = lifecycle,
        minActiveState
    )
    val initialState = remember { mutableStateOf<T?>(null) }
    if (initialState.value == null && state.value != null) {
        initialState.value = state.value
    }
    return initialState
}
