package com.rahul.jott.dsm.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @param modifier
 * @param productImageSection
 * @param infoSection
 */
@Composable
fun InfoSectionComponent(
    modifier: Modifier = Modifier,
    productImageSection: @Composable (ColumnScope.() -> Unit)? = null,
    infoSection: @Composable ColumnScope.() -> Unit,
) {
    // Info Row
    Row(modifier.fillMaxWidth()) {
        productImageSection?.let {
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                it()
            }
        }
        // Info Column
        Column(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterVertically),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            infoSection()
        }
    }
}
