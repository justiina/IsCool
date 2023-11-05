package com.example.iscool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.iscool.ui.theme.IsCoolTheme
import com.example.iscool.ui.theme.Screens.PlayGameScreen
import com.example.iscool.ui.theme.Screens.StartGameScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.iscool.ui.theme.Screens.EndGameScreen

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
        startDestination = "startGameRoute"
    ){
            composable("startGameRoute") {
                StartGameScreen(navController)
            }
            composable("PlayGameRoute") {
                PlayGameScreen(navController)
            }
            composable("EndGameRoute") {
                EndGameScreen(navController)
        }
    }
}


