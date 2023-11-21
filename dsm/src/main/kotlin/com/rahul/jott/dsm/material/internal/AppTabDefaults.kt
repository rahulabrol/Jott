package com.rahul.jott.dsm.material.internal

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.rahul.jott.dsm.material.IconDefaults
import com.rahul.jott.dsm.theme.AppTheme

internal object AppTabDefaults {
    /**
     * The default large Tab item text color
     */
    val LargeItemTextColor: Color
        @Composable
        get() = AppTheme.colors.primary

    /**
     * The default large Tab item text style
     */
    val LargeItemTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.subtitle1

    /**
     * The default large Tab item icon background size
     */
    val LargeIconBackgroundSize: Dp
        @Composable
        get() = IconDefaults.IconBackgroundSize

    /**
     * The default large Tab item icon size
     */
    val LargeIconSize: Dp
        @Composable
        get() = IconDefaults.LargeIconSize

    /**
     * The default Tab item icon background shape
     */
    val IconBackgroundShape: Shape
        @Composable
        get() = CircleShape

    /**
     * The default Tab normal item text color
     */
    val ItemTextColor: Color
        @Composable
        get() = AppTheme.colors.primary

    /**
     * The default Tab normal item text style
     */
    val ItemTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.subtitle1

    /**
     * The default Tab normal item icon background
     */
    val ItemIconBackgroundColorNormal: Color
        @Composable
        get() = AppTheme.colors.background

    /**
     * The default Tab selected item icon background color
     */
    val ItemIconBackgroundColorSelected: Color
        @Composable
        get() = AppTheme.colors.backgroundSecondary

    /**
     * The default color of a tab that is selected
     * */
    val TabSelectedColor: Color
        @Composable
        get() = AppTheme.colors.primary
}
