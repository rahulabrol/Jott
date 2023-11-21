package com.rahul.jott.dsm.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

/**
 * A class that models the app theme shapes available
 *
 * @property small The default app wide small [CornerBasedShape]
 * @property smallDp The default app wide small shape in the form of [Dp]
 * @property medium The default app wide medium [CornerBasedShape]
 * @property mediumDp The default app wide medium shape in the form of [Dp]
 * @property large The default app wide large [CornerBasedShape]
 * @property largeDp The default app wide large shape in the form of [Dp]
 * @property zero The default app wide zero [CornerBasedShape]
 */
@Immutable
data class AppShapes(
    val small: CornerBasedShape,
    val smallDp: Dp,
    val medium: CornerBasedShape,
    val mediumDp: Dp,
    val large: CornerBasedShape,
    val largeDp: Dp,
    val zero: CornerBasedShape,
)
