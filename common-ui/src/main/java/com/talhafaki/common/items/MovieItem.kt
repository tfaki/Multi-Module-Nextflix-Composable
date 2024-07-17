package com.talhafaki.common.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.talhafaki.common.theme.Typography

/**
 * Created by tfakioglu on 12.December.2021
 */
@Composable
fun MovieItem(posterPath: String, title: String, desc: String, rating: String) {

    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Row(
            Modifier
                .padding(all = 4.dp)
                .fillMaxSize()
        ) {

            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
                    .aspectRatio(0.7f)
                    .clip(RoundedCornerShape(8.dp)),
                painter = rememberAsyncImagePainter(
                    model = posterPath
                ),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )

            Column(
                verticalArrangement = Top,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 12.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))

                RatingBar(
                    rating = rating,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = desc,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.bodyMedium.copy(
                        color = Color.LightGray
                    ),
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.6.sp
                )
            }
        }
    }
}
