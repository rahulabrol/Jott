package com.rahul.jott.dsm.material

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.BadgedBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * A BadgeBox is used to decorate [content] with a [badge] that can contain dynamic information,
 * such
 * as the presence of a new notification or a number of pending requests. Badges can be icon only
 * or contain short text.
 *
 * A common use case is to display a badge with bottom navigation items.
 * For more information, see [Bottom Navigation](https://material.io/components/bottom-navigation#behavior)
 *
 * A simple icon with badge example looks like:
 * @sample androidx.compose.material.samples.BottomNavigationItemWithBadge
 *
 * @param badge the badge to be displayed - typically a [Badge]
 * @param modifier optional [Modifier] for this item
 * @param content the anchor to which this badge will be positioned
 */
@Composable
fun AppBadgeBox(
    modifier: Modifier = Modifier,
    badge: @Composable BoxScope.() -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    BadgedBox(
        modifier = modifier,
        badge = badge,
        content = content
    )
}
