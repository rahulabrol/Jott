package com.rahul.jott.dsm.material.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy

internal object AppAlertDialogDefaults {
    private const val dismissOnBackPress: Boolean = true
    private const val dismissOnClickOutside: Boolean = true
    private const val usePlatformDefaultWidth: Boolean = true
    private const val DEFAULT_ELEVATION: Int = 6
    private val securePolicy: SecureFlagPolicy = SecureFlagPolicy.Inherit

    @OptIn(ExperimentalComposeUiApi::class)
    val dialogProperties: DialogProperties
        @Composable
        get() = DialogProperties(
            dismissOnBackPress = dismissOnBackPress,
            dismissOnClickOutside = dismissOnClickOutside,
            securePolicy = securePolicy,
            usePlatformDefaultWidth = usePlatformDefaultWidth,
        )

    val Elevation: Dp
        @Composable get() = DEFAULT_ELEVATION.dp
}
