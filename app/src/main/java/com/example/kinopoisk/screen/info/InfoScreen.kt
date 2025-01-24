package com.example.kinopoisk.screen.info

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kinopoisk.R


data class InfoFilm(
    val image: String,
    val nameRu: String,
    val nameOriginal: String,
    val year: Int,
    val countries: List<String>,
    val genres: List<String>,
    val filmLength: Int,
    val slogan: String,
    val ratingK: Float,
    val ratingI: Float,
    val ratingKVC: Int,
    val ratingIVC: Int,
    val description: String, // ПРОВЕРЯТЬ НА ШОРТ ДЕСКРИПТИОН !!!!
    val webUrl: String,
    val age: String,
    val type: String
)


@Composable
fun InfoScreen(film: InfoFilm) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.image_1),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier.padding(start = 52.dp, end = 52.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                film.nameRu,
                modifier = Modifier.padding(bottom = 5.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight(700)
            )
            Text(
                text = film.nameOriginal + " " + film.age.substring(3),
                modifier = Modifier.padding(bottom = 5.dp),
                fontSize = 8.sp,
                fontWeight = FontWeight(500)
            )

            Text(
                text = if (film.type == "TV_SERIES") "О сериале" else "О фильме",
                modifier = Modifier.padding(bottom = 5.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight(700)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    "Год производства",
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = film.year.toString(),
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    "Страна",
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = film.countries.joinToString(","),
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    "Жанры",
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = film.genres.joinToString(","),
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
            }


            val hours = film.filmLength / 60
            val minutes = film.filmLength % 60
            val len = hours.toString() + ":" + minutes.toString()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    "Время",
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = film.filmLength.toString() + " мин. / " + len,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    "Слоган",
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = film.slogan,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                        .padding(bottom = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(R.drawable.rating4),
                        contentDescription = null,
                        modifier = Modifier.padding(bottom = 10.dp).height(32.dp).width(93.dp)
                    )
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.g8),
                            contentDescription = null,
                            modifier = Modifier.height(22.dp).width(22.dp)
                        )
                        Text(
                            text = "${film.ratingI}/10",
                            fontSize = 10.sp,
                            fontWeight = FontWeight(300)
                        )
                        Text(
                            text = film.ratingIVC.toString(),
                            fontSize = 10.sp,
                            fontWeight = FontWeight(300)
                        )
                    }
                }
                Column (
                    modifier = Modifier.weight(1f)
                        .padding(bottom = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    Image(
                        painter = painterResource(R.drawable.rating5),
                        contentDescription = null,
                        modifier = Modifier.padding(bottom = 10.dp).height(32.dp).width(93.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.g8),
                            contentDescription = null,
                            modifier = Modifier.height(22.dp).width(22.dp)
                        )
                        Text(
                            text = "${film.ratingK}/10",
                            fontSize = 10.sp,
                            fontWeight = FontWeight(300)
                        )
                        Text(
                            text = film.ratingKVC.toString(),
                            fontSize = 10.sp,
                            fontWeight = FontWeight(300)
                        )
                    }
                }

            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp),
                thickness = 1.dp,
                color = Color(189, 189, 189)
            )

            Text(
                text = "Описание",
                fontSize = 10.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.padding(bottom = 5.dp)
            )

            Text(
                text = film.description,
                fontSize = 10.sp,
                fontWeight = FontWeight(300)
            )

            Button(
                onClick = {},
                colors = ButtonColors(
                    containerColor = Color(100, 100, 100),
                    contentColor = Color.White,
                    disabledContentColor = Color(100, 100, 100),
                    disabledContainerColor = Color.White,

                )
            ) {
                Text("Открыть на сайте Кинопоиск", fontSize = 10.sp, fontWeight = FontWeight(700))

            }
            Button(
                onClick = {},
                colors = ButtonColors(
                    containerColor = Color(100, 100, 100),
                    contentColor = Color.White,
                    disabledContentColor = Color(100, 100, 100),
                    disabledContainerColor = Color.White,

                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.asd),
                    contentDescription = null,
                    modifier = Modifier.height(33.dp).width(33.dp).padding(end = 10.dp)
                )
                Text("Добавить в избранное", fontSize = 10.sp, fontWeight = FontWeight(700))

            }
        }
    }
}


@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun InfoScreenPreview() {
    InfoScreen(
        film = InfoFilm(
            image = "https://kinopoiskapiunofficial.tech/images/posters/kp_small/4470907.jpg",
            nameRu = "asdasdasdasd",
            nameOriginal = "adsdsf",
            year = 23423,
            countries = listOf("asdffd", "sdf"),
            genres = listOf("asd", "asd"),
            filmLength = 234,
            slogan = "ddsjoifa",
            ratingK = 6.1f,
            ratingI = 6f,
            ratingKVC = 12424,
            ratingIVC = 542,
            description = "adfhcvmnsnvsghfgdfjgbnsudhkfbvsfvgdfvbdnfkjvnsfnvksvksfvnkds",
            webUrl = "https://www.kinopoisk.ru/film/4470907/",
            age = "age18",
            type = "TV_SERIES"
        )
    )
}