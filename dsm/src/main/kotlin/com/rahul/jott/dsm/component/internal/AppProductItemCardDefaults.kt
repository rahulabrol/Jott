package com.rahul.jott.dsm.component.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.theme.AppTheme
import com.rahul.jott.dsm.theme.internal.AppHighlightColors

object AppProductItemCardDefaults {
    private const val DEFAULT_ELEVATION = 4
    private const val DEFAULT_PRODUCT_IMAGE_BOX_HEIGHT = 115
    private const val DEFAULT_PRODUCT_IMAGE_BOX_WIDTH = 95
    private const val DEFAULT_PRODUCT_IMAGE_HEIGHT = 99
    private const val DEFAULT_PRODUCT_IMAGE_WIDTH = 80
    private const val DEFAULT_PRODUCT_MERCHANDISING_ICON_HEIGHT = 24
    private const val DEFAULT_PRODUCT_MERCHANDISING_ICON_PADDING_END = 4
    private const val DEFAULT_PRODUCT_MERCHANDISING_TEXT_PADDING = 4
    private const val DEFAULT_PRODUCT_PERCENTAGE_OFF_PADDING_START = 4

    val BackgroundColor: Color
        @Composable
        get() = AppTheme.colors.surface

    val Elevation: Dp
        @Composable
        get() = DEFAULT_ELEVATION.dp

    val Shape: Shape
        @Composable
        get() = AppTheme.shapes.medium

    val ProductImageBoxHeight: Dp
        @Composable
        get() = DEFAULT_PRODUCT_IMAGE_BOX_HEIGHT.dp

    val ProductImageBoxWidth: Dp
        @Composable
        get() = DEFAULT_PRODUCT_IMAGE_BOX_WIDTH.dp

    val ProductNameTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.h4

    val InfoProductNameTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.h6

    val ProductLocationAndProximityTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body3

    val ProductScoreShape: Shape
        @Composable
        get() = AppTheme.shapes.small

    val ProductScoreBackgroundColor: Color
        @Composable
        get() = AppHighlightColors.secondary

    val ProductScoreTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.subtitle2

    val ProductScoreTextColor: Color
        @Composable
        get() = AppTheme.colors.onPrimaryHighEmphasis

    val ProductScoreTagAndReviewsTextColor: Color
        @Composable
        get() = AppTheme.colors.textColor

    val ProductScoreTagAndReviewsTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body3

    val ProductImageHeight: Dp
        @Composable
        get() = DEFAULT_PRODUCT_IMAGE_HEIGHT.dp

    val ProductImageWidth: Dp
        @Composable
        get() = DEFAULT_PRODUCT_IMAGE_WIDTH.dp

    val ProductImageShape: Shape
        @Composable
        get() = AppTheme.shapes.medium

    val ProductImageContentScale: ContentScale
        @Composable
        get() = ContentScale.Crop

    val ProductMerchandisingIconHeight: Dp
        @Composable
        get() = DEFAULT_PRODUCT_MERCHANDISING_ICON_HEIGHT.dp

    val ProductMerchandisingIconPaddingEnd: Dp
        @Composable
        get() = DEFAULT_PRODUCT_MERCHANDISING_ICON_PADDING_END.dp

    val ProductMerchandisingIconTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body4

    val ProductMerchandisingIconTextColor: Color
        @Composable
        get() = AppTheme.colors.primaryVariant

    val ProductMerchandisingBaseTextColor: Color
        @Composable
        get() = AppTheme.colors.textColor

    val ProductMerchandisingPrimaryTextColor: Color
        @Composable
        get() = AppTheme.colors.primaryVariant

    val ProductMerchandisingLightTextColor: Color
        @Composable
        get() = AppTheme.colors.primary

    val ProductMerchandisingTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body3

    val ProductStrikethroughPriceTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.button2

    val ProductStrikethroughPriceTextColor: Color
        @Composable
        get() = AppTheme.colors.onSurfaceMediumEmphasis

    val ProductStrikethroughPriceTextDecoration: TextDecoration
        @Composable
        get() = TextDecoration.LineThrough

    val ProductCurrentPriceTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.h4

    val ProductCurrentPriceTextColor: Color
        @Composable
        get() = AppTheme.colors.textColor

    val ProductRoomsLeftTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body3

    val ProductRoomsLeftTextColor: Color
        @Composable
        get() = AppTheme.colors.error

    val ProductOffPriceByTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body3

    val ProductOffPriceByTextColor: Color
        @Composable
        get() = AppTheme.colors.primaryVariant

    val ProductPercentageOffPaddingStart: Dp
        @Composable
        get() = DEFAULT_PRODUCT_PERCENTAGE_OFF_PADDING_START.dp

    val ProductMainContentBadgeTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body4

    val ProductMainContentExpressDealPillTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.body4

    val ProductAdShape: Shape
        @Composable
        get() = AppTheme.shapes.small

    val ProductAdBackgroundColor: Color
        @Composable
        get() = AppTheme.colors.background

    val ProductAdTextStyle: TextStyle
        @Composable
        get() = AppTheme.typography.subtitle2

    val ProductAdTextColor: Color
        @Composable
        get() = AppTheme.colors.onBackgroundMediumEmphasis
}
