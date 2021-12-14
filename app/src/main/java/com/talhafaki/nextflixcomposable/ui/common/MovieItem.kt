package com.talhafaki.nextflixcomposable.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.talhafaki.data.remote.NextflixService
import com.talhafaki.data.remote.response.Movie
import com.talhafaki.domain.entity.NetworkMovie

/**
 * Created by tfakioglu on 12.December.2021
 */
@Composable
fun MovieItem(movie: NetworkMovie) {

    val backgroundColor = MaterialTheme.colors.background
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface(color = backgroundColor) {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Image(
                    modifier = Modifier
                        .size(120.dp),
                    painter = rememberImagePainter(
                        data = movie.posterUrl,
                        builder = {
                            scale(Scale.FILL)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = ""
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = movie.title,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = movie.overview,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
