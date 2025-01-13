package com.example.kinopoisk.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kinopoisk.news.components.FilmComponents


@Composable
fun NewsScreen(){
    Column (
        modifier = Modifier
            .padding(start = 17.dp, end = 19.dp)
    ){
        Text(
            text = "Новинки",
            modifier = Modifier.padding(top = 14.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(700)
        )

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
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun NewsScreenPreview(){
    NewsScreen()
}

