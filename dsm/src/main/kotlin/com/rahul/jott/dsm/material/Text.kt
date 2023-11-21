package com.rahul.jott.dsm.material

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.rahul.jott.dsm.theme.AppTheme

/**
 * High level app specific element that displays text and provides semantics / accessibility information.
 * This element is the app default text element.
 * When using this element, the content will animate when set.
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
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textColor,
    textDecoration: TextDecoration? = null,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign = TextAlign.Start,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.body2
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textDecoration = textDecoration,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        style = style
    )
}

/**
 * High level app specific element that displays text and provides semantics / accessibility information.
 * This element is the app default text element.
 * When using this element, the content will animate when set.
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
fun AppText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = TextAlign.Start,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.body2
) {
    Text(
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
