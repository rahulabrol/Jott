package com.rahul.jott.dsm.material.internal

import androidx.compose.ui.unit.dp

internal object AppProgressIndicatorDefaults {
    /**
     * The default opacity applied to the indicator color to create the background color in a
     * [AppLinearProgressIndicator].
     */
    const val IndicatorBackgroundOpacity = 0.24f

    /**
     * Default stroke width for [AppCircularProgressIndicator], and default height for
     * [AppLinearProgressIndicator].
     *
     * This can be customized with the `strokeWidth` parameter on [AppCircularProgressIndicator],
     * and by passing a layout modifier setting the height for [AppLinearProgressIndicator].
     */
    val StrokeWidth = 2.dp
}
