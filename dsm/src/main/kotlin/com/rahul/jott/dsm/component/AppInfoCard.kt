package com.rahul.jott.dsm.component
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.component.internal.AppProductItemCardDefaults
import com.rahul.jott.dsm.material.AppCard
import com.rahul.jott.dsm.material.AppText
import com.rahul.jott.dsm.R

/**
 * @param modifier
 * @param backgroundColor
 * @param shape
 * @param elevation
 * @param productImageSection
 * @param infoSection
 * @param onClicked
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppInfoCard(
    modifier: Modifier,
    backgroundColor: Color = AppProductItemCardDefaults.BackgroundColor,
    shape: Shape = AppProductItemCardDefaults.Shape,
    elevation: Dp = AppProductItemCardDefaults.Elevation,
    productImageSection: @Composable (ColumnScope.() -> Unit)? = null,
    infoSection: @Composable ColumnScope.() -> Unit,
    onClicked: () -> Unit
) {
    AppCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
            ),
        backgroundColor = backgroundColor,
        shape = shape,
        elevation = elevation,
        onClick = onClicked
    ) {
        InfoSectionComponent(
            modifier = modifier.padding(
                top = 4.dp,
                bottom = 4.dp,
            ),
            productImageSection = productImageSection,
            infoSection = infoSection
        )
    }
}

/**
 * App info card preview
 *
 */
@Preview
@Composable
fun AppInfoCardPreview() {
    AppInfoCard(
        modifier = Modifier,
        productImageSection = {
            Image(
                painter = painterResource(id = R.drawable.ic_splash_screen),
                contentDescription = null
            )
        },
        infoSection = {
            AppText(text = "Info Section Slot")
        },
        onClicked = {}
    )
}
