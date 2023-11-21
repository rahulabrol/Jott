package com.rahul.jott.dsm.component

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import com.rahul.jott.dsm.component.internal.SearchFieldDefaults
import com.rahul.jott.dsm.material.AppSurface
import com.rahul.jott.dsm.material.AppText
import com.rahul.jott.dsm.material.internal.AppTextDefaults
import com.rahul.jott.dsm.theme.AppTheme

@Composable
private fun ConstraintLayoutScope.ContentStart(
    ref: ConstrainedLayoutReference,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .constrainAs(ref) {
                centerVerticallyTo(parent)
                start.linkTo(anchor = parent.start)
            }
    ) {
        content()
    }
}

@Composable
private fun ConstraintLayoutScope.MainContent(
    startContentRef: ConstrainedLayoutReference,
    mainContentRef: ConstrainedLayoutReference,
    endContentRef: ConstrainedLayoutReference,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(start = SearchFieldDefaults.MainContentStartMargin.dp)
            .constrainAs(mainContentRef) {
                width = Dimension.fillToConstraints
                linkTo(
                    top = parent.top,
                    bottom = parent.bottom,
                    end = endContentRef.start,
                    start = startContentRef.end,
                    horizontalBias = SearchFieldDefaults.MainContentHorizontalBias,
                )
            }
    ) {
        content()
    }
}

@Composable
private fun ConstraintLayoutScope.ContentEnd(
    ref: ConstrainedLayoutReference,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .constrainAs(ref) {
                centerVerticallyTo(parent)
                end.linkTo(anchor = parent.end)
            }
    ) {
        content()
    }
}

/**
 * A composable the composes an app search field that is used to search for Priceline's products.
 *
 * @param modifier An optional [Modifier] the this fields root
 * @param backgroundColor The background color. Use [Color.Transparent] to have no color
 * @param elevation The size of the shadow below the surface. Note that It will not affect z index
 * of the Surface. If you want to change the drawing order you can use `Modifier.zIndex`.
 * @param shape Defines the surface's shape as well its shadow. A shadow is only
 *  displayed if the [elevation] is greater than zero.
 * @param contentStart The icon/image to append to the start of the search field
 * @param contentEnd The icon/image to append to the end of the search field
 * @param mainContent The content to display in this search field, usually a [SearchFieldAnnotatedText]
 * or a [SearchFieldText]
 */
@Composable
fun AppSearchField(
    modifier: Modifier = Modifier,
    backgroundColor: Color = SearchFieldDefaults.BackgroundColor,
    elevation: Dp = SearchFieldDefaults.Elevation,
    shape: Shape = SearchFieldDefaults.Shape,
    contentStart: @Composable () -> Unit,
    contentEnd: @Composable (() -> Unit)? = null,
    mainContent: @Composable () -> Unit
) {
    AppSurface(
        modifier = modifier
            .height(height = SearchFieldDefaults.Height),
        backgroundColor = backgroundColor,
        elevation = elevation,
        shape = shape
    ) {
        AppSearchFieldContent(
            contentStart = contentStart,
            mainContent = mainContent,
            contentEnd = contentEnd,
        )
    }
}

/**
 * A composable the composes an app search field that is used to search for Priceline's products.
 *
 * This version of [AppSearchField] is responsible for a click handling as well al everything else that
 * a regular Surface does:
 *
 * @param modifier An optional [Modifier] the this fields root
 * @param enabled Controls the enabled state of the surface. When `false`, this search field will not
 * be clickable
 * @param color The background color. Use [Color.Transparent] to have no color
 * @param elevation The size of the shadow below the search field. Note that It will not affect z index
 * of the Surface. If you want to change the drawing order you can use `Modifier.zIndex`.
 * @param shape Defines the search field's shape as well its shadow. A shadow is only
 *  displayed if the [elevation] is greater than zero.
 * @param role The type of user interface element. Accessibility services might use this to
 * describe the element or do customizations. For example, if the Surface acts as a button, you
 * should pass the [Role.Button]
 * @param border Optional border to draw on top of the search field
 * @param contentDescription Semantic / accessibility label
 * @param onClick Callback to be called when the search field is clicked
 * @param contentStart The icon/image to append to the start of the search field
 * @param contentEnd The icon/image to append to the end of the search field
 * @param mainContent The content to display in this search field, usually a [SearchFieldAnnotatedText]
 * or a [SearchFieldText]
 */
@ExperimentalMaterialApi
@Composable
fun AppSearchField(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = SearchFieldDefaults.Shape,
    color: Color = SearchFieldDefaults.BackgroundColor,
    elevation: Dp = SearchFieldDefaults.Elevation,
    border: BorderStroke? = null,
    contentDescription: String?,
    onClick: () -> Unit,
    contentStart: @Composable () -> Unit,
    contentEnd: @Composable (() -> Unit)? = null,
    mainContent: @Composable () -> Unit
) {
    AppSurface(
        modifier = modifier
            .height(height = SearchFieldDefaults.Height)
            .semantics(mergeDescendants = true) {
                contentDescription?.let { this@semantics.contentDescription = it }
            },
        enabled = enabled,
        shape = shape,
        color = color,
        elevation = elevation,
        border = border,
        onClick = onClick,
    ) {
        AppSearchFieldContent(
            contentStart = contentStart,
            mainContent = mainContent,
            contentEnd = contentEnd,
        )
    }
}

/**
 * App search field that displays annotated text and provides semantics / accessibility information.
 * This element is the app default text to be displayed in [AppSearchField]
 *
 * @param text The basic data structure of text with multiple styles. To construct an [AnnotatedString] you
 * can use [Builder].
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
fun SearchFieldAnnotatedText(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    color: Color = AppTextDefaults.defaultTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Start,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    softWrap: Boolean = true,
    maxLines: Int = 1,
    style: TextStyle = AppTheme.typography.body1
) {
    Crossfade(targetState = text, label = "") {
        Text(
            modifier = modifier,
            text = it,
            color = color,
            textDecoration = textDecoration,
            textAlign = textAlign,
            overflow = overflow,
            softWrap = softWrap,
            maxLines = maxLines,
            style = style
        )
    }
}

/**
 * App search field text that displays text and provides semantics / accessibility information.
 * This element is the app default text to be displayed in [AppSearchField]
 *
 * @param text The basic data structure of text with multiple styles. To construct an [AnnotatedString] you
 * can use [Builder].
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
fun SearchFieldText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = AppTextDefaults.onSurfaceHighEmphasis,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Start,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    softWrap: Boolean = true,
    maxLines: Int = 1,
    style: TextStyle = AppTheme.typography.body1
) {
    Crossfade(targetState = text) {
        AppText(
            modifier = modifier,
            text = it,
            color = color,
            textDecoration = textDecoration,
            textAlign = textAlign,
            overflow = overflow,
            softWrap = softWrap,
            maxLines = maxLines,
            style = style
        )
    }
}

@Composable
private fun AppSearchFieldContent(
    contentStart: @Composable () -> Unit,
    contentEnd: @Composable (() -> Unit)? = null,
    mainContent: @Composable () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .padding(paddingValues = SearchFieldDefaults.padding)
    ) {
        val (
            startContentRef,
            mainContentRef,
            endContentRef
        ) = createRefs()

        createHorizontalChain(
            startContentRef,
            mainContentRef,
            endContentRef,
            chainStyle = ChainStyle.SpreadInside
        )

        ContentStart(
            ref = startContentRef,
            content = contentStart,
        )
        MainContent(
            startContentRef = startContentRef,
            mainContentRef = mainContentRef,
            endContentRef = endContentRef,
            content = mainContent
        )

        contentEnd?.let { content ->
            ContentEnd(
                ref = endContentRef,
                content = content
            )
        }
    }
}
