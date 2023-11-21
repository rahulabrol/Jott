package com.rahul.jott.dsm.material

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.material.internal.AppTabDefaults
import com.rahul.jott.dsm.material.internal.AppTabRowIndicatorDefaults
import com.rahul.jott.dsm.theme.AppTheme

/**
 * <a href="https://material.io/components/tabs#fixed-tabs" class="external" target="_blank">App specific Material Design fixed tabs</a>.
 *
 * Fixed tabs display all tabs in a set simultaneously. They are best for switching between related
 * content quickly, such as between transportation methods in a map. To navigate between fixed tabs,
 * tap an individual tab, or swipe left or right in the content area.
 *
 * [Fixed tabs image](https://developer.android.com/images/reference/androidx/compose/material/fixed-tabs.png)
 *
 * A TabRow contains a row of [AppTab]s, and displays an indicator underneath the currently
 * selected tab. A TabRow places its tabs evenly spaced along the entire row, with each tab
 * taking up an equal amount of space.
 *
 * @param modifier An optional Modifier for this TabRow
 * @param selectedTabIndex The index of the currently selected tab
 * @param backgroundColor The background color for the TabRow. Use [Color.Transparent] to have
 * no color.
 * @param contentColor The preferred content color provided by this TabRow to its children.
 * @param indicatorColor
 * @param indicatorVerticalPadding vertical padding on each side of the indicator
 * @param indicatorHorizontalPadding horizontal padding on each side of the indicator
 * @param indicator the indicator that represents which tab is currently selected. By default this
 * will be a [AppTabRowIndicator]. Note that this indicator will be forced to fill up the
 * entire TabRow, so you should use [TabRowDefaults.tabIndicatorOffset] or similar to
 * animate the actual drawn indicator inside this space, and provide an offset from the start.
 * @param divider The divider displayed at the bottom of the TabRow. This provides a layer of
 * separation between the TabRow and the content displayed underneath.
 * @param tabs The tabs inside this TabRow. Typically this will be multiple [AppTab]s. Each element
 * inside this lambda will be measured and placed evenly across the TabRow, each taking up equal
 * space.
 */
@Composable
fun AppTabRow(
    modifier: Modifier = Modifier,
    selectedTabIndex: Int,
    backgroundColor: Color = AppTheme.colors.surface,
    contentColor: Color = AppTheme.colors.primary,
    indicatorColor: Color = AppTheme.colors.primary,
    indicatorVerticalPadding: Dp = AppTabRowIndicatorDefaults.IndicatorVerticalPadding,
    indicatorHorizontalPadding: Dp = AppTabRowIndicatorDefaults.IndicatorHorizontalPadding,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = @Composable {
        AppTabRowIndicator(
            tabPosition = it[selectedTabIndex],
            backgroundColor = indicatorColor,
            verticalPadding = indicatorVerticalPadding,
            horizontalPadding = indicatorHorizontalPadding,
        )
    },
    divider: @Composable () -> Unit = @Composable { /* No Divider */ },
    tabs: @Composable () -> Unit
) {
    TabRow(
        modifier = modifier,
        selectedTabIndex = selectedTabIndex,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        indicator = indicator,
        divider = divider,
        tabs = tabs
    )
}

/**
 * Default app specific indicator, which will be positioned at the bottom of the AppTabRow, on top of the divider
 *
 * @param modifier Modifier for the indicator's layout
 * @param tabPosition The index of the selected AppTab
 * @param verticalPadding vertical padding on each side of the indicator
 * @param horizontalPadding horizontal padding on each side of the indicator
 * @param height The height of the indicator
 * @param backgroundColor The color of the indicator
 * @param backgroundShape The shape of the indicator
 */
@Composable
fun AppTabRowIndicator(
    modifier: Modifier = Modifier,
    tabPosition: TabPosition,
    verticalPadding: Dp = AppTabRowIndicatorDefaults.IndicatorVerticalPadding,
    horizontalPadding: Dp = AppTabRowIndicatorDefaults.IndicatorHorizontalPadding,
    height: Dp = AppTabRowIndicatorDefaults.IndicatorHeight,
    backgroundColor: Color = AppTheme.colors.primary,
    backgroundShape: Shape = AppTheme.shapes.small
) {
    Spacer(
        modifier
            .tabIndicatorOffset(tabPosition)
            .padding(
                top = verticalPadding,
                bottom = verticalPadding,
                start = horizontalPadding,
                end = horizontalPadding
            )
            .height(height = height)
            .background(
                color = backgroundColor,
                shape = backgroundShape
            )
    )
}

/**
 * * <a href="https://material.io/components/tabs" class="external" target="_blank">An app specific Material Design tab</a>.
 *
 * Tabs organize content across different screens, data sets, and other interactions.
 *
 * [Tab image](https://developer.android.com/images/reference/androidx/compose/material/tab.png)
 *
 * A Tab represents a single page of content using a text label and/or icon. It represents its
 * selected state by tinting the text label and/or image with [selectedContentColor].
 *
 * This should typically be used inside of a [AppTabRow]
 *
 * This Tab a generic Tab that is not opinionated about its content.
 *
 *
 * @param modifier Optional [Modifier] for this tab
 * @param selected Whether this tab is selected or not
 * @param onClick The callback to be invoked when this tab is selected
 * @param content The content that makes the inside of this tab
 */
@Composable
fun AppTab(
    modifier: Modifier = Modifier,
    selected: Boolean,
    selectedContentColor: Color = AppTabDefaults.TabSelectedColor,
    onClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Tab(
        modifier = modifier,
        selected = selected,
        selectedContentColor = selectedContentColor,
        onClick = onClick,
        content = content
    )
}

/**
 * The content of an [AppTab].
 *
 * @param modifier An optional [Modifier] for this tab
 * @param selected Whether this tab is selected or not
 * @param text The text label for this tab
 */
@Composable
fun AppTabItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    text: String,
    iconResId: Int? = null
) {
    Row(modifier = modifier) {
        iconResId?.let {
            Image(
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(end = 4.dp),
                painter = painterResource(id = it),
                contentDescription = null
            )
        }
        AppTabText(
            modifier = Modifier.padding(vertical = 8.dp),
            text = text,
            selected = selected,
            color = AppTabDefaults.ItemTextColor,
            style = AppTabDefaults.ItemTextStyle
        )
    }
}

/**
 * The content of an [AppTab].
 *
 * @param modifier An optional [Modifier] for this tab
 * @param selected Whether this tab is selected or not
 * @param text The text label for this tab
 * @param iconResId The icon resource id for this tab
 */
@Composable
fun AppTabLargeItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    text: String,
    @DrawableRes iconResId: Int,
) {
    Column(
        modifier = modifier
            .padding(
                top = 8.dp,
                bottom = 8.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppTabLargeItemIcon(
            selected = selected,
            iconResId = iconResId
        )
        Spacer(
            modifier = Modifier.height(
                height = 4.dp
            )
        )
        AppTabText(
            text = text,
            selected = selected,
            color = AppTabDefaults.LargeItemTextColor,
            style = AppTabDefaults.LargeItemTextStyle
        )
    }
}

/**
 * The Image that is the Icon of an [AppTabLargeItem].
 *
 * @param modifier An option [Modifier] for this Image Icon
 * @param selected Whether the tab this Image Icon is in, is selected
 * @param colorNormal The normal color of the Image Icon background
 * @param colorSelected The color of a selected Image Icon background
 * @param largeIconSize The size of the overall Icon
 * @param largeIconBackgroundSize The size of the Image Icon within the tab
 * @param iconResId The Image Icon resource id.
 */
@Composable
fun AppTabLargeItemIcon(
    modifier: Modifier = Modifier,
    selected: Boolean,
    colorNormal: Color = AppTabDefaults.ItemIconBackgroundColorNormal,
    colorSelected: Color = AppTabDefaults.ItemIconBackgroundColorSelected,
    largeIconBackgroundSize: Dp = AppTabDefaults.LargeIconBackgroundSize,
    largeIconSize: Dp = AppTabDefaults.LargeIconSize,
    shape: Shape = AppTabDefaults.IconBackgroundShape,
    iconResId: Int
) {
    Box(
        modifier = modifier
            .size(size = largeIconBackgroundSize)
            .background(
                color = if (selected) colorSelected else colorNormal,
                shape = shape
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(size = largeIconSize),
            painter = painterResource(id = iconResId),
            contentDescription = null
        )
    }
}

/**
 * The text label for an or [AppTabItem] or [AppTabLargeItem]
 *
 * @param modifier An optional [Modifier] for this text
 * @param selected Whether the tab is selected
 * @param text The text of this label
 * @param color [Color] to apply to the text.
 * @param style Style configuration for the text such as color, font, line height etc.
 */
@Composable
private fun AppTabText(
    modifier: Modifier = Modifier,
    selected: Boolean,
    text: String,
    color: Color,
    style: TextStyle
) {
    AppText(
        modifier = modifier,
        text = text,
        color = color,
        style = style,
        fontWeight = if (selected) FontWeight.Bold else null
    )
}
