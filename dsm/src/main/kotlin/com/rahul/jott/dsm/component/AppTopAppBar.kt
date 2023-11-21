package com.rahul.jott.dsm.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.material.AppText
import com.rahul.jott.dsm.material.AppTextButton
import com.rahul.jott.dsm.R
import com.rahul.jott.dsm.theme.AppTheme
import com.rahul.jott.dsm.theme.JottTheme

/**
 * @param modifier
 * @param paddingStart
 * @param paddingTop
 * @param paddingBottom
 * @param paddingEnd
 * @param iconHeight
 * @param iconWidth
 * @param tint
 * @param iconId
 * @param contentDescription
 * @param testTag
 * @param onClick
 */
@Composable
fun AppTopAppBarIconAction(
    modifier: Modifier = Modifier,
    paddingStart: Dp = 4.dp,
    paddingTop: Dp = 4.dp,
    paddingBottom: Dp = 4.dp,
    paddingEnd: Dp = 4.dp,
    iconHeight: Dp = 40.dp,
    iconWidth: Dp = 24.dp,
    tint: Color = AppTheme.colors.background,
    @DrawableRes iconId: Int,
    contentDescription: String? = null,
    testTag: String,
    onClick: () -> Unit = { },
) {
    IconButton(
        modifier = modifier
            .testTag(testTag),
        onClick = onClick,
    ) {
        Icon(
            modifier = modifier
                .width(iconHeight)
                .height(iconWidth)
                .padding(
                    start = paddingStart, top = paddingTop, bottom = paddingBottom, end = paddingEnd
                )
                .testTag(testTag),
            painter = painterResource(id = iconId),
            tint = tint,
            contentDescription = contentDescription,
        )
    }
}

/**
 * App top app bar text action
 *
 * @param modifier
 * @param paddingStart
 * @param paddingTop
 * @param paddingBottom
 * @param paddingEnd
 * @param color
 * @param text
 * @param testTag
 * @param onClick
 */
@Composable
fun AppTopAppBarTextAction(
    modifier: Modifier = Modifier,
    paddingStart: Dp = 4.dp,
    paddingTop: Dp = 4.dp,
    paddingBottom: Dp = 4.dp,
    paddingEnd: Dp = 4.dp,
    color: Color = AppTheme.colors.onPrimaryHighEmphasis,
    style: TextStyle = AppTheme.typography.button1,
    text: String,
    testTag: String,
    onClick: () -> Unit = { },
) {
    AppTextButton(
        modifier = modifier
            .testTag(testTag),
        onClick = onClick,
    ) {
        AppText(
            modifier = modifier
                .padding(
                    start = paddingStart, top = paddingTop, bottom = paddingBottom, end = paddingEnd
                )
                .testTag(testTag),
            text = text,
            color = color,
            style = style
        )
    }
}

/**
 * App top app bar icon text action
 *
 * @param modifier
 * @param iconHeight
 * @param iconWidth
 * @param tint
 * @param iconId
 * @param contentDescription
 * @param textColor
 * @param style
 * @param text
 * @param testTag
 * @param onClick
 */
@Composable
fun AppTopAppBarIconTextAction(
    modifier: Modifier = Modifier,
    iconHeight: Dp = 40.dp,
    iconWidth: Dp = 24.dp,
    tint: Color = AppTheme.colors.background,
    @DrawableRes iconId: Int,
    contentDescription: String? = null,
    textColor: Color = AppTheme.colors.onPrimaryHighEmphasis,
    style: TextStyle = AppTheme.typography.button1,
    text: String,
    testTag: String,
    onClick: () -> Unit = { },
) {
    Spacer(modifier = Modifier.width(16.dp))

    Row(
        modifier = modifier
            .clickable {
                onClick()
            }
            .testTag(testTag)
    ) {
        Icon(
            modifier = Modifier
                .width(iconHeight)
                .height(iconWidth)
                .align(alignment = Alignment.CenterVertically),
            painter = painterResource(id = iconId),
            tint = tint,
            contentDescription = contentDescription,
        )
        AppText(
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically),
            text = text,
            color = textColor,
            style = style
        )
    }
}

@Composable
@Preview
private fun AppTopAppBarIconActionPreview() {
    JottTheme {
        AppTopAppBarIconAction(
            iconId = R.drawable.ic_splash_screen,
            testTag = "testTag",
        )
    }
}
