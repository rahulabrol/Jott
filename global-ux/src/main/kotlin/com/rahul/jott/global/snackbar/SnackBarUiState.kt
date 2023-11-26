package com.rahul.jott.global.snackbar

import androidx.compose.material.SnackbarDuration
import com.rahul.jott.global.base.utils.TextResource

/**
 * Ui State to model SnackBars in the application
 *
 * @property message
 * @property actionLabel
 * @property actionId
 * @property duration
 */
data class SnackBarUiState(
    val message: TextResource,
    val actionLabel: TextResource,
    val actionId: String? = null,
    val duration: SnackbarDuration = SnackbarDuration.Short
)
