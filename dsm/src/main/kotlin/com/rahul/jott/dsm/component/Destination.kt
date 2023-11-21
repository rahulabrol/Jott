package com.rahul.jott.dsm.component

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.rahul.jott.dsm.component.internal.DestinationCardDefaults
import com.rahul.jott.dsm.material.AppCard
import com.rahul.jott.dsm.material.AppText
import com.rahul.jott.dsm.theme.AppTheme
import com.rahul.jott.dsm.theme.JottTheme

/**
 * @param modifier
 * @param text
 * @param image
 * @param onDestinationClicked
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppDestinationCard(
    modifier: Modifier = Modifier,
    text: String,
    image: Uri? = null,
    @DrawableRes placeholder: Int? = null,
    @DrawableRes error: Int? = null,
    onDestinationClicked: () -> Unit,
    onError: ((AsyncImagePainter.State.Error) -> Unit)? = null,
) {
    AppCard(
        modifier = modifier
            .fillMaxWidth()
            .height(
                height = DestinationCardDefaults.Height
            )
            .padding(
                start = 8.dp,
                end = 8.dp
            ),
        shape = DestinationCardDefaults.Shape,
        elevation = DestinationCardDefaults.Elevation,
        onClick = { onDestinationClicked() }
    ) {
        Box(
            contentAlignment = Alignment.BottomStart
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalForegroundGradientScrim(
                        color = Color.Black,
                        startYPercentage = 0.6f,
                    ),
                model = image,
                placeholder = placeholder?.let { painterResource(id = it) },
                error = error?.let { painterResource(id = it) },
                onError = onError,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )

            AppText(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        bottom = 16.dp
                    ),
                text = text,
                color = AppTheme.colors.onPrimaryHighEmphasis,
                style = AppTheme.typography.h5
            )
        }
    }
}

/**
 * App destination card preview
 *
 */
@Composable
@Preview
fun AppDestinationCardPreview() {
    JottTheme {
        AppDestinationCard(
            text = "New York",
            onDestinationClicked = {}
        )
    }
}
