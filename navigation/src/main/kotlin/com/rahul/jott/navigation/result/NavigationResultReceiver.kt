package com.rahul.jott.navigation.result

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import com.rahul.jott.navigation.NavigationData

typealias SaveStateDataHandlerList<T> = List<SavedStateDataHandler<T>>
typealias DeeplinkPairList = List<Pair<String, String>>

/**
 * @param savedStateHandle
 * @param handler
 */
@Composable
fun NavigationResultReceiver(
    savedStateHandle: SavedStateHandle?,
    handler: SavedStateDataHandler<out NavigationData>
) {
    NavigationResultReceiver(
        savedStateHandle = savedStateHandle,
        handlers = listOf(handler)
    )
}

/**
 * @param savedStateHandle
 * @param handlers
 */
@Composable
fun NavigationResultReceiver(
    savedStateHandle: SavedStateHandle?,
    handlers: SaveStateDataHandlerList<out NavigationData>
) {
    savedStateHandle?.let { handle ->
        for (handler in handlers) {
            val savedStateData = handler.navigationResult
            val result: NavigationData? = handle[savedStateData.id]

            result?.let {
                @Suppress("UNCHECKED_CAST")
                (handler as SavedStateDataHandler<NavigationData>).handleResult(it)
            }
            handle.remove<NavigationData>(savedStateData.id)
        }
    }
}