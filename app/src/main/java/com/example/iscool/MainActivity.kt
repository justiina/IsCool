package com.example.iscool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.iscool.ui.theme.IsCoolTheme
import com.example.iscool.ui.theme.Screens.PlayGameScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IsCoolTheme {
                IsCoolApp()
            }
        }
    }
}

@Preview
@Composable
fun IsCoolApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "firstRoute"
    ){
            composable("firstRoute") {
            }
            composable("secondRoute") {
            }
    }

    //Kun ottaa alla olevan osan pois kommenteista ja laittaa PictureWithButton osan kommentteihin niin saa näkyviin StartGameScreenin
    //StartGameScreen()
    PlayGameScreen()
    //EndGameScreen()
}



