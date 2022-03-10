package com.talhafaki.common.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.talhafaki.common.theme.Typography

/**
 * Created by tfakioglu on 12.December.2021
 */

@Composable
fun GridItem(posterPath: String, title: String, desc: String) {
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
            ImageContainer(posterPath = posterPath)

            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.body1.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                maxLines = 2
            )

            if (desc.isNotEmpty()) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    text = desc,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.body2.copy(color = Color.White)
                )
            }
            Spacer(Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ImageContainer(posterPath: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(8.dp),
            painter = rememberImagePainter(
                data = posterPath
            ),
            contentScale = ContentScale.Fit,
            contentDescription = ""
        )
    }
}