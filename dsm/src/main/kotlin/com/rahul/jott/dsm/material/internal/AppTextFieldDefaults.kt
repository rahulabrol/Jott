package com.rahul.jott.dsm.material.internal

import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import com.rahul.jott.dsm.theme.AppTheme

object AppTextFieldDefaults {
    /**
     * The default shape used for a [TextField]'s background
     */
    val TextFieldShape: Shape
        @Composable
        get() = AppTheme.shapes.small
            .copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize)

    /**
     * the style to be applied to the input text.
     */
    val TextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body2

    /**
     * software keyboard options that contains configuration such as
     * [KeyboardType] and [ImeAction]
     */
    val KeyboardOption: KeyboardOptions
        @Composable
        get() = KeyboardOptions.Default

    /**
     * when the input service emits an IME action, the corresponding callback
     * is called. Note that this IME action may be different from what you specified in
     * [KeyboardOptions.imeAction].
     */
    @OptIn(ExperimentalComposeUiApi::class)
    val KeyboardAction: KeyboardActions
        @Composable
        get() {
            val keyboardController = LocalSoftwareKeyboardController.current
            return KeyboardActions {
                keyboardController?.hide()
            }
        }

    /**
     * if the text field should request virtual keyboard or no.
     * Virtual keyboard is shown, when keyboard focused is captured by the text field
     */
    val RequestKeyboardFocus: Boolean = false

    /**
     * [TextFieldColors] that will be used to resolve color of the text, content
     * (including label, placeholder, leading and trailing icons, indicator line) and background for
     * this text field in different states. See [TextFieldDefaults.textFieldColors]
     */
    val TextFieldColors: TextFieldColors
        @Composable
        get() = TextFieldDefaults.textFieldColors(
            textColor = LocalContentColor.current.copy(LocalContentAlpha.current),
            disabledTextColor = LocalContentColor.current.copy(LocalContentAlpha.current).copy(ContentAlpha.disabled),
            backgroundColor = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = TextFieldDefaults.BackgroundOpacity),
            cursorColor = AppTheme.colors.primary,
            errorCursorColor = AppTheme.colors.error,
            focusedIndicatorColor = AppTheme.colors.primary.copy(alpha = ContentAlpha.high),
            unfocusedIndicatorColor = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = TextFieldDefaults.UnfocusedIndicatorLineOpacity),
            disabledIndicatorColor = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = TextFieldDefaults.UnfocusedIndicatorLineOpacity)
                .copy(alpha = ContentAlpha.disabled),
            errorIndicatorColor = AppTheme.colors.error,
            leadingIconColor = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = TextFieldDefaults.IconOpacity),
            disabledLeadingIconColor = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = TextFieldDefaults.IconOpacity)
                .copy(alpha = ContentAlpha.disabled),
            errorLeadingIconColor = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = TextFieldDefaults.IconOpacity),
            trailingIconColor = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = TextFieldDefaults.IconOpacity),
            disabledTrailingIconColor = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = TextFieldDefaults.IconOpacity)
                .copy(alpha = ContentAlpha.disabled),
            errorTrailingIconColor = AppTheme.colors.error,
            focusedLabelColor = AppTheme.colors.primary.copy(alpha = ContentAlpha.high),
            unfocusedLabelColor = AppTheme.colors.onSurfaceHighEmphasis.copy(ContentAlpha.medium),
            disabledLabelColor = AppTheme.colors.onSurfaceHighEmphasis.copy(ContentAlpha.medium)
                .copy(ContentAlpha.disabled),
            errorLabelColor = AppTheme.colors.error,
            placeholderColor = AppTheme.colors.onSurfaceHighEmphasis.copy(ContentAlpha.medium),
            disabledPlaceholderColor = AppTheme.colors.onSurfaceHighEmphasis.copy(ContentAlpha.medium)
                .copy(ContentAlpha.disabled)
        )
}
