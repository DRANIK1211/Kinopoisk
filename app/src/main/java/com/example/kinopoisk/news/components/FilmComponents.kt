package com.example.kinopoisk.news.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePreviewHandler
import com.example.kinopoisk.R
import java.util.Vector

data class Film(
    var name: String,
    var imageUrl: String,
    var year: Int,
    var duration: Int,
    var genres: List<String>,
    var countrys:  List<String>,
    var premiereDate: String,
    var favorites: Boolean,
    var originalName: String? = null
)

@Composable
fun FilmComponents(
    film: Film
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 10.dp),
            thickness = 1.dp,
            color = Color.Black
        )
        Row(
            modifier = Modifier.fillMaxWidth(),

            ) {
            AsyncImage(
                model = film.imageUrl,
                contentDescription = null,
                placeholder = painterResource(R.drawable.poster),
                modifier = Modifier.width(85.dp)
            )
            Column(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 20.dp)
            ) {
                Text(
                    text = film.name,
                    fontSize = 17.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = if (film.originalName != null) "${film.originalName}, ${film.year}, ${film.duration} мин." else "${film.year}, ${film.duration} мин.",
                    fontSize = 11.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(top = 5.dp)
                )
                val res: String = film.genres.joinToString(" ")
                Text(
                    text = "${film.countrys.joinToString { " " }} · ${res}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight(300),
                    modifier = Modifier.padding(top = 5.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 3.dp)

                ) {
                    Image(

                        imageVector = ImageVector.vectorResource(R.drawable.time),
                        contentDescription = null,
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp)
                            .padding(end = 4.dp)
                    )
                    Text(
                        text = film.premiereDate.split("-").reversed().joinToString("."),
                        fontSize = 11.sp,
                        fontWeight = FontWeight(300)
                    )
                }
            }

            Image(
                painter = if (film.favorites) painterResource(R.drawable.vector1) else painterResource(
                    R.drawable.vector0
                ),
                contentDescription = null,
                modifier = Modifier.width(35.dp)
            )

        }
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun FilmComponentsPreview() {
    FilmComponents(
        Film(
            name = "Волшебник Изумрудного города. Дорога из жёлтого кирпича",
            imageUrl = "https://kinopoiskapiunofficial.tech/images/posters/kp/5047471.jpg",
            year = 2024,
            duration = 103,
            genres = listOf("фэнтези", "приключения", "семейный"),
            countrys = listOf("Россия"),
            premiereDate = "2020-06-01",
            favorites = false
        )
    )

}

//if (favorites) painterResource(R.drawable.vector) else