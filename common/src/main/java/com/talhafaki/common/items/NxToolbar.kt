package com.talhafaki.common.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talhafaki.common.R
import com.talhafaki.common.theme.Typography

/**
 * Created by talhafaki on 15.03.2022.
 */
@Preview
@Composable
fun NxToolbar(clickBackButton: () -> Unit) {
    //TODO: hide ripple effect
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .padding(horizontal = 6.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.Start
    ) {

        Box(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
                .clickable {
                       clickBackButton.invoke()
                },
            contentAlignment = Alignment.CenterStart
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back),
                contentDescription = "",
                tint = Color.LightGray
            )
        }

        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Title",
                style = Typography.body1.copy(
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}