package com.rahul.jott.global

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import kotlinx.coroutines.CoroutineScope

/**
 * @param onEvent
 */
@Composable
fun LifecycleObserverEffect(
    onEvent: (Lifecycle.Event) -> Unit
) {
    val permissionCheckerObserver = remember {
        LifecycleEventObserver { _, event ->
            onEvent(event)
        }
    }
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifecycle, permissionCheckerObserver) {
        lifecycle.addObserver(permissionCheckerObserver)
        onDispose { lifecycle.removeObserver(permissionCheckerObserver) }
    }
}

/**
 * Execute a [DisposableEffect] on [Lifecycle.Event]
 *
 * @param lifecycleEvent
 * @param block to be executed
 */
@Composable
fun DisposableEffectOnLifecycleEvent(
    lifecycleEvent: Lifecycle.Event,
    block: suspend CoroutineScope.() -> Unit
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val latestLifecycleEvent = remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
    DisposableEffect(lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            latestLifecycleEvent.value = event
        }
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }

    if (latestLifecycleEvent.value == lifecycleEvent) {
        LaunchedEffect(latestLifecycleEvent) {
            block()
        }
    }
}
