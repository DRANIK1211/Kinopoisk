package com.example.kinopoisk.screen.search.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.kinopoisk.R

data class FilmSearch(
    var ID: Long,
    var name: String,
    var imageUrl: String,
    var year: String,
    var duration: String,
    var genres: List<String>,
    var countrys:  List<String>,
    var rating: String,
    var favorites: Boolean,
    var originalName: String? = null,
    var typeFilm: String
)

@Composable
fun FilmComponentsSearch(
    film: FilmSearch
) {

    Column(
        modifier = Modifier.fillMaxWidth()
            .clickable {

            }
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
                    text = film.name + if(film.typeFilm == "TV_SERIES") " (Сериал)" else "",
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
                        .background(Color(0, 123, 0))

                ) {
                    Text(
                        text = film.rating,
                        fontSize = 11.sp,
                        fontWeight = FontWeight(300),
                        modifier = Modifier.padding(top = 5.dp, start=5.dp, end=5.dp, bottom = 5.dp)
                        , color = Color(255, 255 ,255)
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
    FilmComponentsSearch(
        FilmSearch(
            name = "Волшебник",
            imageUrl = "https://kinopoiskapiunofficial.tech/images/posters/kp/5047471.jpg",
            year = "2024",
            duration = "01:01",
            genres = listOf("фэнтези", "приключения", "семейный"),
            countrys = listOf("Россия"),
            rating = "7.1",
            favorites = false,
            typeFilm = "TV_SERIES",
            ID = 135416
        )
    )

}

//if (favorites) painterResource(R.drawable.vector) else