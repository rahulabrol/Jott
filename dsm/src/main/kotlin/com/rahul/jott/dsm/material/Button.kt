package com.rahul.jott.dsm.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.FloatingActionButtonElevation
import androidx.compose.material.RadioButtonColors
import androidx.compose.material3.*
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.rahul.jott.dsm.material.internal.AppButtonDefaults
import com.rahul.jott.dsm.theme.AppTheme

/**
 * <a href="https://material.io/components/buttons#contained-button" class="external" target="_blank">An app specific Material Design contained button</a>.
 *
 * Contained buttons are high-emphasis, distinguished by their use of elevation and fill. They
 * contain actions that are primary to your app.
 *
 * ![Contained button image](https://developer.android.com/images/reference/androidx/compose/material/contained-button.png)
 *
 * If you need to add an icon just put it inside the [content] slot together with a spacing
 * and a text:
 *
 * @param onClick Will be called when the user clicks the button
 * @param modifier Modifier to be applied to the button
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Pass `null` here to disable
 * @param shape Defines the button's shape as well as its shadow
 * @param border Border to draw around the button
 * @param colors [ButtonColors] that will be used to resolve the background and content color for
 * this button in different states. See [ButtonDefaults.buttonColors].
 * @param contentPadding The spacing values to apply internally between the container and the content
 */
@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    shape: Shape = AppButtonDefaults.Shape,
    colors: ButtonColors = AppButtonDefaults.buttonColors(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = AppButtonDefaults.ContentPadding,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier
            .height(height = AppButtonDefaults.HeightNormal),
        enabled = enabled,
        onClick = onClick,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
        content = content
    )
}

/**
 * High level app specific element that displays text and provides semantics / accessibility information.
 * This element is the app default button text to be displayed in [AppButton]
 *
 * @param text The text to be displayed.
 * @param modifier [Modifier] to apply to this layout node.
 * @param color [Color] to apply to the text.
 * @param textDecoration The decorations to paint on the text (e.g., an underline).
 * See [TextStyle.textDecoration].
 * @param textAlign The alignment of the text within the lines of the paragraph.
 * See [TextStyle.textAlign].
 * @param overflow How visual overflow should be handled.
 * @param softWrap Whether the text should break at soft line breaks. If false, the glyphs in the
 * text will be positioned as if there was unlimited horizontal space. If [softWrap] is false,
 * [overflow] and TextAlign may have unexpected effects.
 * @param maxLines An optional maximum number of lines for the text to span, wrapping if
 * necessary. If the text exceeds the given number of lines, it will be truncated according to
 * [overflow] and [softWrap]. If it is not null, then it must be greater than zero.
 * @param style Style configuration for the text such as color, font, line height etc.
 */
@Composable
fun AppButtonText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = AppTheme.colors.onPrimaryHighEmphasis,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Center,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.button1
) {
    AppText(
        modifier = modifier,
        text = text,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        style = style
    )
}

/**
 * <a href="https://material.io/components/buttons#outlined-button" class="external" target="_blank">App specific Material Design outlined button</a>.
 *
 * Outlined buttons are medium-emphasis buttons. They contain actions that are important, but aren't
 * the primary action in an app.
 *
 * [Outlined button image](https://developer.android.com/images/reference/androidx/compose/material/outlined-button.png)
 *
 * @param modifier Modifier to be applied to the button
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 * @param shape Defines the button's shape as well as its shadow
 * states. An OutlinedButton typically has no elevation, see [Button] for a button with elevation.
 * @param border Border to draw around the button
 * @param colors [ButtonColors] that will be used to resolve the background and content color for
 * @param onClick Will be called when the user clicks the button
 * this button in different states. See [ButtonDefaults.outlinedButtonColors].
 */
@Composable
fun AppOutlinedButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = AppButtonDefaults.Shape,
    border: BorderStroke = AppButtonDefaults.outlinedButtonBorder(),
    colors: ButtonColors = AppButtonDefaults.outlinedButtonColors(),
    height: Dp = AppButtonDefaults.HeightNormal,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .height(height = height),
        enabled = enabled,
        shape = shape,
        onClick = onClick,
        border = border,
        colors = colors,
        content = content
    )
}

/**
 * * High level app specific element that displays text and provides semantics / accessibility information.
 * This element is the app default button text to be displayed in [AppOutlinedButton]
 *
 * @param text * @param text The text to be displayed.
 * @param modifier [Modifier] to apply to this layout node.
 * @param color [Color] to apply to the text.
 * @param textDecoration The decorations to paint on the text (e.g., an underline).
 * See [TextStyle.textDecoration].
 * @param textAlign The alignment of the text within the lines of the paragraph.
 * See [TextStyle.textAlign].
 * @param overflow How visual overflow should be handled.
 * @param softWrap Whether the text should break at soft line breaks. If false, the glyphs in the
 * text will be positioned as if there was unlimited horizontal space. If [softWrap] is false,
 * [overflow] and TextAlign may have unexpected effects.
 * @param maxLines An optional maximum number of lines for the text to span, wrapping if
 * necessary. If the text exceeds the given number of lines, it will be truncated according to
 * [overflow] and [softWrap]. If it is not null, then it must be greater than zero.
 * @param style Style configuration for the text such as color, font, line height etc.
 */
@Composable
fun AppOutlinedButtonText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = AppTheme.colors.primary,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Center,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.button1
) {
    AppText(
        modifier = modifier,
        text = text,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        style = style
    )
}

/**
 * <a href="https://material.io/components/buttons#text-button" class="external" target="_blank">Material Design text button</a>.
 *
 * Text buttons are typically used for less-pronounced actions, including those located in dialogs
 * and cards. In cards, text buttons help maintain an emphasis on card content.
 *
 * [Text button image](https://developer.android.com/images/reference/androidx/compose/material/text-button.png)
 *
 * @param onClick Will be called when the user clicks the button
 * @param modifier Modifier to be applied to the button
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. A TextButton typically has no elevation, see [Button] for a button with elevation.
 * @param shape Defines the button's shape as well as its shadow
 * @param colors [ButtonColors] that will be used to resolve the background and content color for
 * this button in different states. See [AppButtonDefaults.textButtonColors].
 */
@Composable
fun AppTextButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = AppButtonDefaults.textButtonColors(),
    shape: Shape = AppButtonDefaults.TextButtonShape,
    elevation: ButtonElevation? = null,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        shape = shape,
        elevation = elevation,
        onClick = onClick,
        content = content
    )
}

/**
 * High level app specific element that displays text and provides semantics / accessibility information.
 * This element is the app default button text to be displayed in [AppTextButton]
 *
 * @param text * @param text The text to be displayed.
 * @param modifier [Modifier] to apply to this layout node.
 * @param color [Color] to apply to the text.
 * @param textDecoration The decorations to paint on the text (e.g., an underline).
 * See [TextStyle.textDecoration].
 * @param textAlign The alignment of the text within the lines of the paragraph.
 * See [TextStyle.textAlign].
 * @param overflow How visual overflow should be handled.
 * @param softWrap Whether the text should break at soft line breaks. If false, the glyphs in the
 * text will be positioned as if there was unlimited horizontal space. If [softWrap] is false,
 * [overflow] and TextAlign may have unexpected effects.
 * @param maxLines An optional maximum number of lines for the text to span, wrapping if
 * necessary. If the text exceeds the given number of lines, it will be truncated according to
 * [overflow] and [softWrap]. If it is not null, then it must be greater than zero.
 * @param style Style configuration for the text such as color, font, line height etc.
 */
@Composable
fun AppTextButtonText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = AppTheme.colors.primary,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Center,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.button2
) {
    AppText(
        modifier = modifier,
        text = text,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        style = style
    )
}

/**
 * <a href="https://material.io/components/buttons-floating-action-button" class="external" target="_blank">An app specific Material Design floating action button</a>.
 *
 * A floating action button (FAB) represents the primary action of a screen.
 *
 * [Floating action button image](https://developer.android.com/images/reference/androidx/compose/material/floating-action-button.png)
 *
 * This FAB is typically used with an [Icon]:
 *
 * @param modifier [Modifier] to be applied to this FAB.
 * @param onClick Callback invoked when this FAB is clicked
 * appearance / behavior of this FAB in different [Interaction]s.
 * @param shape The [Shape] of this FAB
 * @param backgroundColor The background color. Use [Color.Transparent] to have no color
 * @param contentColor The preferred content color for content inside this FAB
 * @param elevation [FloatingActionButtonElevation] used to resolve the elevation for this FAB
 * in different states. This controls the size of the shadow below the FAB.
 * @param content The content of this FAB - this is typically an [Icon].
 */
@Composable
fun AppFloatingActionButton(
    modifier: Modifier = Modifier,
    shape: Shape = AppTheme.shapes.small.copy(CornerSize(percent = 50)),
    backgroundColor: Color = AppTheme.colors.onPrimaryMediumEmphasis,
    contentColor: Color = AppTheme.colors.primary,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    FloatingActionButton(
        modifier = modifier,
        shape = shape,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        onClick = onClick,
        content = content
    )
}

/**
 * <a href="https://material.io/components/radio-buttons" class="external" target="_blank">An app specific Material Design radio button</a>.
 *
 * Radio buttons allow users to select one option from a set.
 *
 * [Radio buttons image](https://developer.android.com/images/reference/androidx/compose/material/radio-buttons.png)
 *
 * [AppRadioButton]s can be combined together with [Text] in the desired layout (e.g. [Column] or
 * [Row]) to achieve radio group-like behaviour, where the entire layout is selectable:
 *
 *
 * @param selected boolean state for this button: either it is selected or not
 * @param onClick callback to be invoked when the RadioButton is being clicked.  If null,
 * then this is passive and relies entirely on a higher-level component to control the state.
 * @param modifier Modifier to be applied to the radio button
 * @param enabled Controls the enabled state of the [RadioButton]. When `false`, this button will
 * not be selectable and appears in the disabled ui state
 * @param colors [RadioButtonColors] that will be used to resolve the color used for this
 * RadioButton in different states. See [RadioButtonDefaults.colors].
 */
@Composable
fun AppRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean = true,
    colors: RadioButtonColors = AppButtonDefaults.appRadioButtonColors(),
    onClick: (() -> Unit)?
) {
    RadioButton(
        modifier = modifier,
        selected = selected,
        enabled = enabled,
        colors = colors,
        onClick = onClick
    )
}
