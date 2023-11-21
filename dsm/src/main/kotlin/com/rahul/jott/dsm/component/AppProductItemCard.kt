package com.rahul.jott.dsm.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.component.internal.AppProductItemCardDefaults
import com.rahul.jott.dsm.material.AppCard
import com.rahul.jott.dsm.theme.AppTheme

/**
 * App product item card
 *
 * @param modifier
 * @param backgroundColor
 * @param shape
 * @param elevation
 * @param badgeSection
 * @param productImageSection
 * @param infoSection
 * @param secondaryInfoSection
 * @param merchandisingSection
 * @param priceSection
 * @param onProductClicked
 * @param border
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppProductItemCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppProductItemCardDefaults.BackgroundColor,
    shape: Shape = AppProductItemCardDefaults.Shape,
    elevation: Dp = AppProductItemCardDefaults.Elevation,
    showDivider: Boolean = true,
    border: BorderStroke? = null,
    badgeSection: @Composable (RowScope.() -> Unit)? = null,
    productImageSection: @Composable (ColumnScope.() -> Unit)? = null,
    infoSection: @Composable ColumnScope.() -> Unit,
    secondaryInfoSection: @Composable (ColumnScope.() -> Unit)? = null,
    merchandisingSection: @Composable ColumnScope.() -> Unit,
    priceSection: @Composable ColumnScope.() -> Unit,
    currentSelectedCardSection: @Composable (ColumnScope.() -> Unit)? = null,
    onProductClicked: () -> Unit
) {
    AppCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp
            ),
        backgroundColor = backgroundColor,
        shape = shape,
        elevation = elevation,
        border = border,
        onClick = onProductClicked
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            currentSelectedCardSection?.let {
                currentSelectedCardSection()
            }

            // Badge Row
            badgeSection?.let {
                Row(
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    badgeSection()
                }
            }

            InfoSectionComponent(
                modifier = Modifier,
                productImageSection = productImageSection,
                infoSection = infoSection
            )

            // PickUp and DropOff Column
            secondaryInfoSection?.let {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                    it()
                }
            }
            if (showDivider) {
                Divider(
                    color = AppTheme.colors.outlineMediumEmphasis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 12.dp, end = 8.dp)
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Merchandising Column
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    merchandisingSection()
                }

                // Price Column
                Column(horizontalAlignment = Alignment.End) {
                    priceSection()
                }
            }
        }
    }
}
