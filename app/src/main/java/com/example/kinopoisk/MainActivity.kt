package com.example.kinopoisk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            KinopoiskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val topLevelRoutes = listOf(
                        TopLevelRoute("Profile", Profile, Icons.Profile),
                        TopLevelRoute("Friends", Friends, Icons.Friends)
                    )
                    Box(Modifier.fillMaxSize().padding(innerPadding)){
                        NavHost(navController, NewsScreen){
                            composable<NewsScreen> {
                                NewsScreen(modifier = Modifier)
                            }
                            composable<SearchScreen> {
                                SearchScreen()
                            }
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun Start(modifier: Modifier = Modifier) {
    SearchScreen()
}

@Preview(device = Devices.PIXEL_4, showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    KinopoiskTheme {
        Start()
    }
}