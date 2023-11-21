package com.rahul.jott.dsm.material.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.rahul.jott.dsm.material.IconDefaults
import com.rahul.jott.dsm.theme.AppTheme

internal object AppBottomNavigationDefaults {
    private const val ITEM_TEXT_MAX_LINES = 1

    /**
     * The default item max text lines
     */
    const val ItemTextMaxLines: Int = ITEM_TEXT_MAX_LINES

    /**
     * The default normal icon size
     */
    val IconSizeNormal: Dp
        @Composable
        get() = IconDefaults.IconSize

    /**
     * The default selected icon size
     */
    val IconSizeSelected: Dp
        @Composable
        get() = IconDefaults.SelectedIconSize

    /**
     * The default background color
     */
    val BackgroundColor: Color
        @Composable
        get() = AppTheme.colors.surface

    /**
     * The default content color
     */
    val ContentColor: Color
        @Composable
        get() = AppTheme.colors.onSurfaceHighEmphasis

    /**
     * The default bottom navigation item text style
     */
    val ItemTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body3

    /**
     * The default bottom navigation selected item color
     */
    val ItemSelectedColor: Color
        @Composable
        get() = AppTheme.colors.colorControlSelected

    /**
     * The default bottom navigation unselected item color
     */
    val ItemUnSelectedColor: Color
        @Composable
        get() = AppTheme.colors.colorControlNormal
}
