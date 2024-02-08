package com.talhafaki.common.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.talhafaki.common.theme.Typography

/**
 * Created by tfakioglu on 12.December.2021
 */

@Composable
fun GridItem(posterPath: String, title: String, desc: String, rating: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 6.dp)
                .padding(top = 6.dp)
                .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
                .fillMaxWidth()
        ) {
            ImageContainer(posterPath = posterPath)

            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                style = MaterialTheme.typography.titleLarge
                    .copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 2
            )

            RatingBar(
                rating = rating,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )

            if (desc.isNotEmpty()) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    text = desc,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.bodyMedium.copy(color = Color.White)
                )
            }
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
                .aspectRatio(0.7f),
            painter = rememberImagePainter(
                data = posterPath
            ),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
    }
}