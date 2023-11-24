package com.rahul.jott.global.base.model

import com.rahul.jott.global.base.utils.TextResource

/**
 * A class that represents an error message
 *
 * @property message The error message
 * @property action The error action label
 */
data class ErrorMessage(
    val message: TextResource,
    val action: TextResource
)
