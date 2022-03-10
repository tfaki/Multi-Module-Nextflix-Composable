package com.talhafaki.common.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun MovieItem(posterPath: String, title: String, desc: String) {

    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colors.background)
    ) {
        Row(
            Modifier
                .padding(all = 4.dp)
                .fillMaxSize()
        ) {

            Image(
                modifier = Modifier
                    .padding(4.dp)
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = rememberImagePainter(
                    data = posterPath
                ),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )

            Column(
                verticalArrangement = Top,
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 12.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = title,
                    style = Typography.body1.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = desc,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.body2.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}
