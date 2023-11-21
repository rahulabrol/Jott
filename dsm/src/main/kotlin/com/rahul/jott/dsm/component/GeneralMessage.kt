package com.rahul.jott.dsm.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.material.AppButton
import com.rahul.jott.dsm.material.AppButtonText
import com.rahul.jott.dsm.material.AppOutlinedButton
import com.rahul.jott.dsm.material.AppOutlinedButtonText
import com.rahul.jott.dsm.theme.AppTheme

/**
 * @param modifier
 * @param title
 * @param description
 * @param image
 * @param actionPrimary
 * @param actionSecondary
 */
@Composable
fun AppGeneralMessage(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    description: @Composable () -> Unit,
    image: @Composable () -> Unit,
    actionPrimary: @Composable (() -> Unit)? = null,
    actionSecondary: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.surface)
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 24.dp
            ),
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            image()
            Spacer(
                modifier = Modifier.height(
                    height = 16.dp
                )
            )
            title()
            Spacer(
                modifier = Modifier.height(
                    height = 8.dp
                )
            )
            description()
        }

        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            actionPrimary?.let {
                actionPrimary()
            }
            actionSecondary?.let {
                /**
                 * This is commented out because there seems to be a bug when laying out
                 * the composables.
                 * Whenever we add this, it causes the action primary to be laid out higher
                 * on the screen then it should.
                 *
                 * Tracking this in [https://priceline.atlassian.net/browse/ANDR-10142]
                 *
                 Spacer(
                 modifier = Modifier.height(
                 height = 16.dp
                 ))
                 */
                actionSecondary()
            }
        }
    }
}

/**
 * @param text
 * @param testTag
 */
@Composable
fun GeneralMessageTitle(
    text: String,
    testTag: String
) {
    Text(
        modifier = Modifier
            .testTag(tag = testTag),
        text = text,
        textAlign = TextAlign.Center,
        style = AppTheme.typography.h3
    )
}

/**
 * @param text
 * @param testTag
 */
@Composable
fun GeneralMessageDescription(
    text: String,
    testTag: String
) {
    Text(
        modifier = Modifier
            .testTag(tag = testTag),
        textAlign = TextAlign.Center,
        text = text,
        style = AppTheme.typography.body1
    )
}

/**
 * @param modifier
 * @param imageResId
 * @param contentDescription
 * @param width
 * @param height
 * @param testTag
 */
@Composable
fun GeneralMessageImage(
    modifier: Modifier = Modifier,
    @DrawableRes imageResId: Int,
    contentDescription: String?,
    width: Dp,
    height: Dp,
    testTag: String,
) {
    Image(
        modifier = modifier
            .size(
                width = width,
                height = height
            )
            .testTag(tag = testTag),
        painter = painterResource(id = imageResId),
        contentDescription = contentDescription
    )
}

/**
 * @param text
 * @param testTag
 * @param onClick
 */
@Composable
fun GeneralMessageActionPrimary(
    text: String,
    testTag: String,
    onClick: () -> Unit
) {
    AppButton(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(tag = testTag),
        onClick = onClick
    ) {
        AppButtonText(text = text)
    }
}

/**
 * @param text
 * @param testTag
 * @param onClick
 */
@Composable
fun GeneralMessageActionSecondary(
    text: String,
    testTag: String,
    onClick: () -> Unit
) {
    AppOutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(tag = testTag),
        onClick = onClick
    ) {
        AppOutlinedButtonText(text = text)
    }
}
