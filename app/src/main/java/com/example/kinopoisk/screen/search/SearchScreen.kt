package com.example.kinopoisk.screen.search

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kinopoisk.R
import com.example.kinopoisk.screen.info.InfoScreenData
import com.example.kinopoisk.screen.news.MainViewModel
import com.example.kinopoisk.screen.news.components.FilmComponents
import com.example.kinopoisk.screen.search.components.FilmComponentsSearch
import kotlinx.serialization.Serializable

@Serializable
object SearchScreen


@Composable
fun SearchScreen(navController: NavController) {
    val viewModel = viewModel<SearchScreenViewModel>()
    var films = viewModel.listFilms.collectAsState()


    val TAG = "qwe"
    var textSearch: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(start = 17.dp, end = 19.dp)
    ) {
        Text(
            text = "Поиск",
            modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
            fontSize = 27.sp,
            fontWeight = FontWeight(700)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextField(
                value = textSearch,
                onValueChange = { newText ->
                    textSearch = newText
                },
                label = { Text("Название") },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 14.dp)

            )
            Button(
                onClick = {
                    viewModel.getSearchFilm(textSearch)


                },
                modifier = Modifier.width(125.dp)

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.search),
                        contentDescription = null,
                        Modifier.height(25.dp).width(25.dp)
                    )
                    Text("Найти", modifier = Modifier.padding(start=10.dp))
                }
            }
        }

        LazyColumn() {
            items(films.value) {
                FilmComponentsSearch(it){
                    navController.navigate(InfoScreenData(it))
                }
            }
        }


    }
}


@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun SearchScreenPreview() {

}