package com.rahul.jott.dsm.material.internal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ContentAlpha
import androidx.compose.material.RadioButtonColors
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.theme.AppTheme

@Suppress("unused")
object AppButtonDefaults {
    private const val HEIGHT_NORMAL = 48
    private const val HEIGHT_SLIM = 32
    private const val BUTTON_HORIZONTAL_PADDING = 16
    private const val BUTTON_VERTICAL_PADDING = 8

    /**
     * The default normal button height for the app
     * */
    val HeightNormal = HEIGHT_NORMAL.dp

    /**
     * The default slim button height for the app
     * */
    val HeightSlim = HEIGHT_SLIM.dp

    val Shape: Shape
        @Composable
        get() = AppTheme.shapes.large

    val TextButtonShape: Shape
        @Composable
        get() = AppTheme.shapes.small

    /**
     * The default content padding used by [Button]
     */
    val ContentPadding = PaddingValues(
        start = BUTTON_HORIZONTAL_PADDING.dp,
        top = BUTTON_VERTICAL_PADDING.dp,
        end = BUTTON_HORIZONTAL_PADDING.dp,
        bottom = BUTTON_VERTICAL_PADDING.dp
    )

    /**
     * Creates a [ButtonColors] that represents the default background and content colors used in
     * an [AppButton].
     *
     * @param containerColor the background color of this [AppButton] when enabled
     * @param contentColor the content color of this [AppButton] when enabled
     * @param disabledContainerColor the background color of this [AppButton] when not enabled
     * @param disabledContentColor the content color of this [AppButton] when not enabled
     * @return A [ButtonColors] with the proper color attributes set
     */
    @Composable
    fun buttonColors(
        containerColor: Color = AppTheme.colors.primary,
        contentColor: Color = contentColorFor(containerColor),
        disabledContainerColor: Color = AppTheme.colors.onSurfaceHighEmphasis.copy(alpha = 0.12f)
            .compositeOver(AppTheme.colors.surface),
        disabledContentColor: Color = AppTheme.colors.onSurfaceHighEmphasis
            .copy(alpha = ContentAlpha.disabled)
    ): ButtonColors = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    /**
     * Creates a [ButtonColors] that represents the default background and content colors used in
     * an [AppOutlinedButton].
     *
     * @param disabledContainerColor the background color of this [AppOutlinedButton]
     * @param contentColor the content color of this [AppOutlinedButton] when enabled
     * @param disabledContentColor the content color of this [AppOutlinedButton] when not enabled
     * @return A [ButtonColors] with the proper color attributes set
     */
    @Composable
    fun outlinedButtonColors(
        disabledContainerColor: Color = AppTheme.colors.surface,
        contentColor: Color = AppTheme.colors.primary,
        disabledContentColor: Color = AppTheme.colors.onSurfaceHighEmphasis
            .copy(alpha = ContentAlpha.disabled)
    ): ButtonColors = ButtonDefaults.buttonColors(
        containerColor = disabledContainerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    /**
     * Creates a [ButtonColors] that represents the default background and content colors used in
     * a [AppTextButton].
     *
     * @param containerColor the background color of this [AppTextButton]
     * @param contentColor the content color of this [AppTextButton] when enabled
     * @param disabledContentColor the content color of this [AppTextButton] when not enabled
     * @return A [ButtonColors] with the proper color attributes set
     */
    @Composable
    fun textButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = AppTheme.colors.primary,
        disabledContentColor: Color = AppTheme.colors.onSurfaceHighEmphasis
            .copy(alpha = ContentAlpha.disabled)
    ): ButtonColors = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = containerColor,
        disabledContentColor = disabledContentColor
    )

    /**
     * Creates a [RadioButtonColors] that will animate between the provided colors according to
     * the Material specification.
     *
     * @param selectedColor the color to use for the RadioButton when selected and enabled.
     * @param unselectedColor the color to use for the RadioButton when unselected and enabled.
     * @param disabledColor the color to use for the RadioButton when disabled.
     * @return the resulting [Color] used for the RadioButton
     */
    @Composable
    fun appRadioButtonColors(
        selectedColor: Color = AppTheme.colors.primary,
        unselectedColor: Color = AppTheme.colors.textColor,
        disabledColor: Color = AppTheme.colors.onSurfaceHighEmphasis.copy(
            alpha = ContentAlpha.disabled
        )
    ): RadioButtonColors = RadioButtonDefaults.colors(
        selectedColor = selectedColor,
        unselectedColor = unselectedColor,
        disabledColor = disabledColor,
    )

    /**
     * Creates a [ButtonColors] that represents the default background and content colors used in
     * an [AppOutlinedButton].
     *
     * @param width
     * @param color
     * @return a [BorderStroke] proper color attributes set
     */
    @Composable
    fun outlinedButtonBorder(
        width: Dp = ButtonDefaults.outlinedButtonBorder.width,
        color: Color = AppTheme.colors.primary
    ): BorderStroke = BorderStroke(
        width = width,
        color = color
    )
}
