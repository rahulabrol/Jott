package com.rahul.jott.dsm.theme.internal

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.R
import com.rahul.jott.dsm.theme.AppShapes

private val RoundedCornerShapeSmall
    @Composable get() = dimensionResource(id = R.dimen.shape_appearance_component_small)
private val RoundedCornerShapeMedium
    @Composable get() = dimensionResource(id = R.dimen.shape_appearance_component_medium)
private val RoundedCornerShapeLarge
    @Composable get() = dimensionResource(id = R.dimen.shape_appearance_component_large)
private val RoundedCornerShapeZero
    @Composable get() = dimensionResource(id = R.dimen.shape_appearance_component_zero)

/**
 * Compose Global Theme shapes config
 */
internal val Shapes: AppShapes
    @Composable get() = shapes()

internal val LocalAppShapesProvider: ProvidableCompositionLocal<AppShapes> =
    staticCompositionLocalOf {
        AppShapes(
            small = RoundedCornerShape(0.dp),
            smallDp = 0.dp,
            medium = RoundedCornerShape(0.dp),
            mediumDp = 0.dp,
            large = RoundedCornerShape(0.dp),
            largeDp = 0.dp,
            zero = RoundedCornerShape(0.dp),
        )
    }

@Composable
private fun shapes() = AppShapes(
    small = RoundedCornerShape(RoundedCornerShapeSmall),
    smallDp = RoundedCornerShapeSmall,
    medium = RoundedCornerShape(RoundedCornerShapeMedium),
    mediumDp = RoundedCornerShapeMedium,
    large = RoundedCornerShape(RoundedCornerShapeLarge),
    largeDp = RoundedCornerShapeLarge,
    zero = RoundedCornerShape(RoundedCornerShapeZero)
)
