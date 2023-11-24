package com.rahul.jott.global.base.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow

// todo - this will be removed when StateHolder2 migration is complete

/**
 * A regular flow with lifecycle that uses the Composable to save the flow
 * with lifecycle during Composable recompositions
 *
 * @param T The flow type
 * @param flow to remember with the lifecycle provided
 * @param lifecycle The Lifecycle where the restarting collecting from this flow work will be kept alive.
 * @param minActiveState Lifecycle.State in which the upstream flow gets collected.
 *                        The collection will stop if the lifecycle falls below that state,
 *                        and will restart if it's in that state again
 * @return a Flow of with lifecycle that is remembered during Composable recompositions
 */
@Composable
fun <T> rememberFlowWithLifecycle(
    flow: Flow<T>,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): State<T?> = remember(flow, lifecycle) {
    flow.flowWithLifecycle(
        lifecycle = lifecycle,
        minActiveState = minActiveState
    )
}.collectAsState(initial = null)
