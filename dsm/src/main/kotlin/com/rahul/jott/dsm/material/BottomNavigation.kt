package com.rahul.jott.dsm.material

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.material.internal.AppBottomNavigationDefaults
import com.rahul.jott.dsm.theme.AppTheme

/**
 * An App specific Material Design bottom navigation item.
 *
 * @param modifier An optional [Modifier] for this item
 * @param selected Whether this item is selected
 * @param selectedContentColor The color of the text label and icon when this item is selected,
 *                             and the color of the ripple.
 * @param unselectedContentColor The color of the text label and icon when this item is not selected
 * @param icon An icon for this item, typically this will be an [Icon]
 * @param label Optional text label for this item
 * @param onClick The callback to be invoked when this item is selected
 */
@Composable
fun RowScope.AppBottomNavigationItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    selectedContentColor: Color = AppBottomNavigationDefaults.ItemSelectedColor,
    unselectedContentColor: Color = AppBottomNavigationDefaults.ItemUnSelectedColor,
    icon: @Composable () -> Unit,
    label: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        modifier = modifier,
        icon = icon,
        label = label,
        selected = selected,
        selectedContentColor = selectedContentColor,
        unselectedContentColor = unselectedContentColor,
        onClick = onClick
    )
}

/**
 * <a href="https://material.io/components/bottom-navigation" class="external" target="_blank">An App specific
 * Material Design bottom navigation</a>.
 *
 * Bottom navigation bars allow movement between primary destinations in an app.
 *
 * [Bottom navigation image](https://developer.android.com/images/reference/androidx/compose/material/bottom-navigation.png)
 *
 * BottomNavigation should contain multiple [BottomNavigationItem]s, each representing a singular
 * destination.
 *
 * See [AppBottomNavigationItem] for configuration specific to each item, and not the overall
 * BottomNavigation component.
 *
 * @param modifier Optional [Modifier] for this BottomNavigation
 * @param backgroundColor The background color for this BottomNavigation
 * @param contentColor The preferred content color provided by this BottomNavigation to its
 * @param content destinations inside this BottomNavigation, this should contain multiple
 * [AppBottomNavigationItem]s
 */
@Composable
fun AppBottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppBottomNavigationDefaults.BackgroundColor,
    contentColor: Color = AppBottomNavigationDefaults.ContentColor,
    content: @Composable RowScope.() -> Unit
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        content = content
    )
}

/**
 * An [Icon] that's intended to be used for a [AppBottomNavigationItem].
 * This Icon animates size depending on the selected state.
 *
 * @param modifier An optional [Modifier] for this item
 * @param selected Whether this item this icon is implemented in, is selected.
 *                 Determines the size of the Icon.
 * @param iconResId The resource id of this Icon
 * @param normalIconSize The normal size of the icon when the item it's implemented in is not selected.
 * @param selectedIconSize The size of the icon when the item it's implemented in is selected
 * @param contentDescription The content description of this Icon if one is applicable.
 */
@Composable
fun AppBottomNavigationItemIcon(
    modifier: Modifier = Modifier,
    selected: Boolean,
    @DrawableRes iconResId: Int,
    hasNotifications: Boolean = false,
    normalIconSize: Dp = AppBottomNavigationDefaults.IconSizeNormal,
    selectedIconSize: Dp = AppBottomNavigationDefaults.IconSizeSelected,
    contentDescription: String?,
) {
    val iconSizeAnimated by animateDpAsState(
        if (selected) selectedIconSize else normalIconSize, label = ""
    )
    AppBadgeBox(
        badge = {
            if (hasNotifications) {
                Badge(
                    modifier = Modifier
                        .requiredSize(12.dp)
                        .offset((-4).dp, 4.dp)
                        .clip(CircleShape)
                        .border(1.dp, AppTheme.colors.surface, CircleShape)
                ) {}
            }
        }
    ) {
        Icon(
            modifier = modifier
                .size(iconSizeAnimated),
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription,
        )
    }
}

/**
 * An [Text] that's intended to be used as the [AppBottomNavigationItem] label.
 *
 * @param modifier An optional [Modifier] for this item
 * @param text The text to display
 * @param maxLines An optional maximum number of lines for the text to span, wrapping if
 * necessary. If the text exceeds the given number of lines, it will be truncated according to
 * [overflow] and [softWrap]. If it is not null, then it must be greater than zero
 * @param overflow How visual overflow should be handled.
 * @param softWrap Whether the text should break at soft line breaks. If false, the glyphs in the
 * text will be positioned as if there was unlimited horizontal space. If [softWrap] is false,
 * [overflow] and TextAlign may have unexpected effects.
 * @param style Style configuration for the text such as color, font, line height etc.
 */
@Composable
fun AppBottomNavigationItemText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = AppBottomNavigationDefaults.ItemUnSelectedColor,
    maxLines: Int = AppBottomNavigationDefaults.ItemTextMaxLines,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    style: TextStyle = AppBottomNavigationDefaults.ItemTextStyle
) {
    AppText(
        modifier = modifier,
        text = text,
        color = color,
        maxLines = maxLines,
        overflow = overflow,
        softWrap = softWrap,
        style = style
    )
}
