package com.example.kinopoisk.screen.info

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun InfoScreen(film: InfoFilm){
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
            modifier = Modifier.padding(start=52.dp, end=52.dp, top=10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                film.nameRu,
                modifier = Modifier.padding(bottom = 5.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight(700)
            )
            Text(
                text = film.nameOriginal +" "+ film.age.substring(3),
                modifier = Modifier.padding(bottom = 5.dp),
                fontSize = 8.sp,
                fontWeight = FontWeight(500)
            )

            Text(
                text = if(film.type == "TV_SERIES") "О сериале" else "О фильме",
                modifier = Modifier.padding(bottom = 5.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight(700)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
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
            ){
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
            ){
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
            ){
                Text(
                    "Время",
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = film.filmLength.toString() + "мин. / " + len,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(300)
                )
            }

        }
    }
}


@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun InfoScreenPreview(){
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