package com.rahul.jott.dsm.material

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.rahul.jott.dsm.theme.AppTheme

/**
 * <a href="https://material.io/components/app-bars-top"
 * class="external" target="_blank">An app specific Material Design top
 * app bar</a>.
 *
 * The top app bar displays information and actions relating to the
 * current screen.
 *
 * [App bars: top
 * image](https://developer.android.com/images/reference/androidx/compose/material/app-bars-top.png)
 *
 * This TopAppBar has slots for a title, navigation icon, and actions.
 * Note that the [title] slot is inset from the start according to
 * spec - for custom use cases such as horizontally centering the title,
 * use the other TopAppBar overload for a generic TopAppBar with no
 * restriction on content.
 *
 * @param title The title to be displayed in the center of the TopAppBar
 * @param modifier The [Modifier] to be applied to this TopAppBar
 * @param navigationIcon The navigation icon displayed at the start of
 *     the TopAppBar. This should typically be
 *     an [IconButton] or [IconToggleButton].
 * @param actions The actions displayed at the end of the TopAppBar.
 *     This should typically be [IconButton]s. The default layout
 *     here is a [Row], so icons inside will be placed horizontally.
 * @param backgroundColor The background color for the TopAppBar. Use
 *     [Color.Transparent] to have no color.
 * @param contentColor The preferred content color provided by this
 *     TopAppBar to its children. Defaults to either the
 *     matching content color for [backgroundColor], or if
 *     [backgroundColor] is not a color from the theme, this
 *     will keep the same value set above this TopAppBar.
 * @param elevation the elevation of this TopAppBar.
 */
@Composable
fun AppTopAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppTheme.colors.surface,
    contentColor: Color = AppTheme.colors.primary,
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
    title: @Composable () -> Unit,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = title,
        navigationIcon = navigationIcon,
        actions = actions,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation
    )
}
