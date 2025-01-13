package com.example.kinopoisk.news.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePreviewHandler
import com.example.kinopoisk.R


@Composable
fun FilmComponents(
    name: String,
    imageUrl: String,
    year:Int,
    duration: Int,
    genres: List<String>,
    country: String,
    premiereDate: String,
    favorites: Boolean
){

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 5.dp),
            thickness = 1.dp,
            color = Color.Black
        )
        Row(
            modifier = Modifier.fillMaxWidth(),

        ){
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                placeholder = painterResource(R.drawable.poster),
                modifier = Modifier.width(60.dp)
            )
            Column(
                modifier = Modifier.weight(0.5f)
            ) {
                Text(
                    text = name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${year}, ${duration} мин.",
                    fontSize = 8.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(top = 5.dp)
                )
                val res: String = genres.joinToString(" ")
                Text(
                    text = "${country} · ${res}",
                    fontSize = 8.sp,
                    fontWeight = FontWeight(300),
                    modifier = Modifier.padding(top = 5.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 3.dp)

                ) {
                    Image(
                        painter = painterResource(R.drawable.time),
                        contentDescription = null,
                        modifier = Modifier.width(7.dp)
                    )
                    Text(
                        text = premiereDate,
                        fontSize = 8.sp,
                        fontWeight = FontWeight(300)
                    )
                }
            }

            Image(
                painter = painterResource(R.drawable.vector0),
                contentDescription = null,
                modifier = Modifier.width(23.dp)
            )

        }
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun FilmComponentsPreview(){
    FilmComponents(
        name = "Волшебник Изумрудного города. Дорога из жёлтого кирпича",
        imageUrl = "https://kinopoiskapiunofficial.tech/images/posters/kp/5047471.jpg",
        year = 2024,
        duration = 103,
        genres = listOf("фэнтези", "приключения", "семейный"),
        country = "Россия",
        premiereDate = "2020-06-01",
        favorites = false
    )

}

//if (favorites) painterResource(R.drawable.vector) else