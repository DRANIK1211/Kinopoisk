package com.example.kinopoisk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.kinopoisk.screen.info.InfoFilm
import com.example.kinopoisk.screen.info.InfoScreen
import com.example.kinopoisk.screen.info.InfoScreenData
import com.example.kinopoisk.screen.news.NewsScreen
import com.example.kinopoisk.screen.search.SearchScreen
import com.example.kinopoisk.ui.theme.KinopoiskTheme

data class TopLevelRoute<T : Any>(
    val name: String,
    val route: T,
    val icon: ImageVector
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            KinopoiskTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBarMenu(navController)
                    }
                ) { innerPadding ->

                    /*val topLevelRoutes = listOf(
                        TopLevelRoute("Profile", Profile, Icons.Profile),
                        TopLevelRoute("Friends", Friends, Icons.Friends)
                    )*/
                    Box(Modifier.fillMaxSize().padding(innerPadding)){
                        NavHost(navController, NewsScreen){
                            composable<NewsScreen> {
                                NewsScreen(modifier = Modifier, navController = navController)
                            }
                            composable<SearchScreen> {
                                SearchScreen(navController = navController)
                            }
                            composable<InfoScreenData>() {
                                var arg = it.toRoute<InfoScreenData>()
                                InfoScreen(id = arg.id)
                            }
                        }
                    }


                }
            }
        }
    }
}


@Composable
fun BottomBarMenu(navController: NavController){
    Row(
        modifier = Modifier.fillMaxWidth().height(80.dp).background(Color(0, 0, 0)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navController.navigate(NewsScreen)
                },
                colors = ButtonColors(
                    containerColor = Color(60, 60, 60),
                    contentColor = Color(255, 255, 255),
                    disabledContainerColor = Color(60, 60, 60),
                    disabledContentColor = Color(255, 255, 255)
                ),
                modifier = Modifier.height(30.dp).width(64.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_new),
                    contentDescription = null,
                    modifier = Modifier.height(30.dp).width(30.dp)
                )
            }
            Text(
                text = "Новинки",
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(255, 255, 255)
            )
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navController.navigate(SearchScreen)
                },
                colors = ButtonColors(
                    containerColor = Color(100, 100, 100),
                    contentColor = Color(255, 255, 255),
                    disabledContainerColor = Color(60, 60, 60),
                    disabledContentColor = Color(255, 255, 255)
                ),
                modifier = Modifier.height(30.dp).width(64.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.search_svgrepo_com__1__1),
                    contentDescription = null,
                    modifier = Modifier.height(30.dp).width(30.dp)
                )
            }
            Text(
                text = "Поиск",
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(255, 255, 255)
            )
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {},
                colors = ButtonColors(
                    containerColor = Color(60, 60, 60),
                    contentColor = Color(255, 255, 255),
                    disabledContainerColor = Color(60, 60, 60),
                    disabledContentColor = Color(255, 255, 255)
                ),
                modifier = Modifier.height(30.dp).width(64.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.zvezda),
                    contentDescription = null,
                    modifier = Modifier.height(30.dp).width(30.dp)
                )
            }
            Text(
                text = "Избранное",
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(255, 255, 255)
            )
        }
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    KinopoiskTheme {

    }
}