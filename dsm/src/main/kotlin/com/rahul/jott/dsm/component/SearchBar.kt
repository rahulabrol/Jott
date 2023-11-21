package com.rahul.jott.dsm.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.rahul.jott.dsm.component.internal.AppSearchBarDefaults
import com.rahul.jott.dsm.material.AppSurface
import com.rahul.jott.dsm.material.AppText
import com.rahul.jott.dsm.material.AppTextField

/**
 * @param modifier
 * @param iconResId
 * @param contentDescription
 * @param tint
 * @param onBackClicked
 */
@Composable
fun RowScope.AppSearchBarIcon(
    modifier: Modifier = Modifier,
    @DrawableRes iconResId: Int,
    contentDescription: String?,
    tint: Color = AppSearchBarDefaults.IconTint,
    onBackClicked: () -> Unit
) {
    IconButton(
        modifier = modifier,
        onClick = onBackClicked
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier
                .padding(
                    start = 0.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        )
    }
}

/**
 * @param modifier
 * @param value
 * @param textFieldHeight
 * @param fontSize
 * @param singleLine
 * @param keyboardOptions
 * @param label
 * @param placeHolder
 * @param colors
 * @param onValueChange
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RowScope.AppSearchBarTextField(
    modifier: Modifier = Modifier,
    value: String,
    textFieldHeight: Dp = AppSearchBarDefaults.TextFieldHeight,
    fontSize: TextUnit,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = AppSearchBarDefaults.KeyboardOptions,
    requestKeyboardFocus: Boolean = false,
    colors: TextFieldColors = AppSearchBarDefaults.TextFieldColors,
    iconId: Int? = null,
    tint: Color = AppSearchBarDefaults.IconTint,
    contentDescription: String? = null,
    label: @Composable () -> Unit,
    placeHolder: @Composable () -> Unit,
    onValueChange: (String) -> Unit,
) {
    Row(
        modifier = modifier.weight(weight = 1f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        iconId?.let {
            Icon(
                painter = painterResource(id = iconId),
                tint = tint,
                contentDescription = contentDescription
            )
        }
        AppTextField(
            modifier = Modifier.height(height = textFieldHeight),
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            textStyle = TextStyle(
                fontSize = fontSize
            ),
            singleLine = singleLine,
            keyboardOptions = keyboardOptions,
            requestKeyboardFocus = requestKeyboardFocus,
            label = label,
            placeholder = placeHolder,
            colors = colors
        )
    }
}

/**
 * @param modifier
 * @param backgroundColor
 * @param contentColor
 * @param elevation
 * @param icon
 * @param textField
 */
@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppSearchBarDefaults.BackgroundColor,
    contentColor: Color = AppSearchBarDefaults.ContentColor,
    elevation: Dp = AppSearchBarDefaults.Elevation,
    icon: @Composable RowScope.() -> Unit,
    textField: @Composable RowScope.() -> Unit
) {
    AppSurface(
        modifier = modifier.fillMaxWidth(),
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 4.dp,
                    end = 16.dp,
                    bottom = 12.dp
                )
        ) {
            icon()
            Spacer(modifier = Modifier.width(16.dp))
            textField()
        }
    }
}

/**
 * @param modifier
 * @param text
 * @param style
 * @param color
 */
@Composable
fun AppSearchBarLabel(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = AppSearchBarDefaults.LabelTextStyle,
    color: Color = AppSearchBarDefaults.LabelTextColor
) {
    AppText(
        modifier = modifier,
        text = text,
        style = style,
        color = color
    )
}

/**
 * @param modifier
 * @param text
 * @param style
 * @param color
 */
@Composable
fun AppSearchBarPlaceHolder(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = AppSearchBarDefaults.PlaceHolderTextStyle,
    color: Color = AppSearchBarDefaults.PlaceHolderTextColor
) {
    AppText(
        modifier = modifier
            .alpha(alpha = 0.5f),
        text = text,
        style = style,
        color = color
    )
}
