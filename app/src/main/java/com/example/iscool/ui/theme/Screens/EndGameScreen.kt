package com.example.iscool.ui.theme.Screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun EndGameScreen(
    navController: NavHostController,
    points: Int
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Game Over",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "You got $points points!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("StartGameRoute") },
            modifier = Modifier
                .width(200.dp)
                .height(48.dp)
        ) {
            Text("Play Again")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Sain $points pistettä pelissä IsCool! Saatko sinä paremmin? Lataa peli täältä: https://github.com/justiina/isCool")
                    type = "text/plain"
                }
                context.startActivity(Intent.createChooser(shareIntent, null))
            },
            modifier = Modifier
                .width(200.dp)
                .height(48.dp)
        ) {
            Text("Jaa pisteesi")
        }
    }
}
