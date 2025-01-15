package com.example.kinopoisk.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.kinopoisk.news.components.Film
import com.example.kinopoisk.news.components.FilmComponents
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NewsScreen(){
    var viewModel:MainViewModel = viewModel<MainViewModel>()
    viewModel.getPremierFilms()
    Column (
        modifier = Modifier
            .padding(start = 17.dp, end = 19.dp)
    ){
        Text(
            text = "Новинки",
            modifier = Modifier.padding(top = 14.dp, bottom = 10.dp),
            fontSize = 27.sp,
            fontWeight = FontWeight(700)
        )


        LazyColumn() {
            items(viewModel.listFilms.value) {
                FilmComponents(it)
            }
        }


    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun NewsScreenPreview(){
    NewsScreen()
}

