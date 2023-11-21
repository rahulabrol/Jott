package com.rahul.jott.dsm.component

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.rahul.jott.dsm.component.internal.BannerDefaults
import com.rahul.jott.dsm.material.AppCard
import com.rahul.jott.dsm.material.AppText
import com.rahul.jott.dsm.theme.AppTheme

/**
 * @param modifier
 * @param title
 * @param message
 * @param label
 * @param icon
 * @param onClick
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppBanner(
    modifier: Modifier,
    backgroundUrl: Uri? = null,
    title: @Composable (RowScope.() -> Unit)?,
    message: @Composable (RowScope.() -> Unit)?,
    label: @Composable (RowScope.() -> Unit)?,
    icon: @Composable (BoxScope.() -> Unit)? = null,
    onClick: () -> Unit = {},
) {
    AppCard(
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth(),
        shape = BannerDefaults.Shape,
        elevation = BannerDefaults.Elevation,
        onClick = onClick,
    ) {
        backgroundUrl?.let {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(it)
                    .size(Size.ORIGINAL)
                    .build()
            )
            Image(
                modifier = modifier.fillMaxHeight(),
                contentScale = ContentScale.FillBounds,
                painter = painter,
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            icon?.let {
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .padding(start = 8.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    icon()
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = icon?.let {
                            12.dp
                        }
                            ?: run {
                                16.dp
                            },
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp,
                    )
            ) {
                title?.let { Row { title() } }
                Spacer(modifier = Modifier.height(4.dp))
                message?.let { Row { message() } }
                Spacer(modifier = Modifier.height(8.dp))
                label?.let { Row { label() } }
            }
        }
    }
}

/**
 * App banner title
 *
 * @param modifier
 * @param text
 */
@Composable
fun AppBannerTitle(
    modifier: Modifier = Modifier,
    text: String
) {
    AppText(
        modifier = modifier,
        text = text,
        style = AppTheme.typography.h6
    )
}

/**
 * @param text
 */
@Composable
fun AppBannerMessage(
    modifier: Modifier = Modifier,
    text: String
) {
    AppText(
        modifier = modifier,
        text = text,
        maxLines = 2,
    )
}

/**
 * @param text
 */
@Composable
fun AppBannerLabel(
    modifier: Modifier = Modifier,
    text: String
) {
    AppText(
        modifier = modifier,
        text = text,
        color = AppTheme.colors.primary,
        style = AppTheme.typography.h6,
    )
}

/**
 * An app banner icon generic composable.
 * A banner icon might have in some instances a circle background.
 * If it does, use [circleBgVisible] to show display that background and [circleBgColor] & [circleBgSize] to control
 * it's appearance. The icon will always be centered in the circle background.
 *
 * @param modifier
 * @param circleBgVisible
 * @param circleBgColor
 * @param circleBgSize
 * @param icon
 * @param iconSize
 * @param contentDescription
 * @param contentScale
 */
@Composable
fun AppBannerIcon(
    modifier: Modifier = Modifier,
    circleBgVisible: Boolean = false,
    circleBgColor: Color = BannerDefaults.CircleBgColor,
    circleBgSize: Dp = BannerDefaults.CircleBgSize,
    @DrawableRes icon: Int,
    iconSize: Dp? = null,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    iconLabel: String? = null,
    iconLabelColor: Color = BannerDefaults.IconLabelColor,
    iconLabelStyle: TextStyle = BannerDefaults.IconLabelStyle
) {
    Box(
        modifier = if (circleBgVisible) {
            modifier
                .size(size = circleBgSize)
                .background(
                    color = circleBgColor,
                    shape = CircleShape
                )
        } else {
            modifier
        },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = iconSize?.let {
                    Modifier.size(size = it)
                } ?: Modifier,
                painter = painterResource(id = icon),
                contentScale = contentScale,
                contentDescription = contentDescription
            )
            iconLabel?.let { label ->
                Spacer(modifier = Modifier.height(8.dp))
                AppText(
                    text = label,
                    color = iconLabelColor,
                    style = iconLabelStyle
                )
            }
        }
    }
}
