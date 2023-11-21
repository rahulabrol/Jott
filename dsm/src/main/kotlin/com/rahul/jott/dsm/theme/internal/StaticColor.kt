package com.rahul.jott.dsm.theme.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.rahul.jott.dsm.R

/**
 * Static color used for non them based color
 *
 * @constructor Create empty Static color
 */
object StaticColor {
    val Black_0: Color
        @Composable
        get() = colorResource(id = R.color.black_0)

    val Black_60: Color
        @Composable
        get() = colorResource(id = R.color.black_60)

    val White_38: Color
        @Composable
        get() = colorResource(id = R.color.white_38)
}
