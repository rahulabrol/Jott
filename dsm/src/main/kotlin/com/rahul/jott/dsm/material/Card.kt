package com.rahul.jott.dsm.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.rahul.jott.dsm.material.internal.AppCardDefaults

/**
 * <a href="https://material.io/components/cards" class="external" target="_blank">An app specific Material Design card</a>.
 *
 * Cards contain content and actions about a single subject.
 *
 * ![Cards image](https://developer.android.com/images/reference/androidx/compose/material/cards.png)
 *
 * This version of Card will block clicks behind it. For clickable card, please use another
 * overload that accepts `onClick` as a parameter.
 *
 *
 * @param modifier Modifier to be applied to the layout of the card.
 * @param shape Defines the card's shape as well its shadow. A shadow is only
 *  displayed if the [elevation] is greater than zero.
 * @param backgroundColor The background color.
 * @param contentColor The preferred content color provided by this card to its children.
 * Defaults to either the matching content color for [backgroundColor], or if [backgroundColor]
 * is not a color from the theme, this will keep the same value set above this card.
 * @param border Optional border to draw on top of the card
 * @param elevation The z-coordinate at which to place this card. This controls
 *  the size of the shadow below the card.
 */
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    shape: Shape = AppCardDefaults.Shape,
    backgroundColor: Color = AppCardDefaults.BackgroundColor,
    contentColor: Color = AppCardDefaults.ContentColor,
    border: BorderStroke? = null,
    elevation: Dp = AppCardDefaults.Elevation,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = shape,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        border = border,
        elevation = elevation,
        content = content
    )
}

/**
 * [AppCard]s are [AppSurface]s that display content and actions on a single topic.
 *
 * This version of Card provides click handling as well. If you do not want Card to handle
 * clicks, consider using another overload.
 *
 * @sample androidx.compose.material.samples.ClickableCardSample
 *
 * @param onClick callback to be called when the card is clicked
 * @param modifier Modifier to be applied to the layout of the card.
 * @param enabled Controls the enabled state of the card. When `false`, this card will not
 * be clickable
 * @param shape Defines the card's shape as well its shadow. A shadow is only
 *  displayed if the [elevation] is greater than zero.
 * @param backgroundColor The background color.
 * @param contentColor The preferred content color provided by this card to its children.
 * Defaults to either the matching content color for [backgroundColor], or if [backgroundColor]
 * is not a color from the theme, this will keep the same value set above this card.
 * @param border Optional border to draw on top of the card
 * @param elevation The z-coordinate at which to place this card. This controls
 *  the size of the shadow below the card.
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Card. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance
 * / behavior of this card in different [Interaction]s.
 */
@ExperimentalMaterialApi
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = AppCardDefaults.Shape,
    backgroundColor: Color = AppCardDefaults.BackgroundColor,
    contentColor: Color = AppCardDefaults.ContentColor,
    border: BorderStroke? = null,
    elevation: Dp = AppCardDefaults.Elevation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        border = border,
        elevation = elevation,
        interactionSource = interactionSource,
        content = content
    )
}
