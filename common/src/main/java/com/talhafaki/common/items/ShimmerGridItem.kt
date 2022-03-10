package com.talhafaki.common.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerGridItem(brush: Brush) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(color = MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(180.dp)
                    .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 6.dp)
                    .background(brush = brush)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(start = 12.dp, top = 4.dp, end = 12.dp, bottom = 8.dp)
                    .background(brush = brush)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(start = 12.dp, top = 4.dp, end = 12.dp, bottom = 8.dp)
                    .background(brush = brush)
            )
        }
    }
}