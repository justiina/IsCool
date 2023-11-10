package com.example.iscool.ui.theme.Screens

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
    val sharedPreferences = context.getSharedPreferences("GameScores", Context.MODE_PRIVATE)
    val topScores = getTopScores(sharedPreferences)
    saveScoreIfTop(sharedPreferences, points)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(animationSpec = tween(1000)) + expandVertically(animationSpec = tween(1000)),
            exit = fadeOut()
        ) {
            Text(
                text = "Game Over",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(
            visible = true,
            enter = fadeIn(animationSpec = tween(1000)) + expandIn(animationSpec = tween(1000)),
            exit = fadeOut()
        ) {
            Text(
                text = "You got $points points!",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Play Again Button
        Button(
            onClick = { navController.navigate("StartGameRoute") },
            modifier = Modifier
                .width(200.dp)
                .height(48.dp)
        ) {
            Text("Play Again")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Share Button
        Button(
            onClick = {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "I scored $points points in IsCool! Can you beat me? Download the game here: https://github.com/justiina/isCool")
                    type = "text/plain"
                }
                context.startActivity(Intent.createChooser(shareIntent, null))
            },
            modifier = Modifier
                .width(200.dp)
                .height(48.dp)
        ) {
            Text("Share Your Score")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Top Scores List
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(animationSpec = tween(1500)) + slideInVertically(animationSpec = tween(1500)),
            exit = fadeOut()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Top Scores", style = MaterialTheme.typography.headlineMedium)
                topScores.forEach { score ->
                    Text("Score: $score", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

fun getTopScores(sharedPreferences: SharedPreferences): List<Int> {
    // This is a simple implementation. You should replace this with your logic.
    return listOf(100, 90, 80) // Dummy data
}

fun saveScoreIfTop(sharedPreferences: SharedPreferences, score: Int) {
    // Implement the logic to save the score if it's a top score
}
