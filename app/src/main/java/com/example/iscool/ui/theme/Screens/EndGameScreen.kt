package com.example.iscool.ui.theme.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.iscool.R

@Composable
fun EndGameScreen(
    navController: NavHostController
){
    Column(
    ) {
            Text(
                text = "EndGameScreen",
            )
            Text(
                text = "You got a lot of points!",
            )
            Button(
                onClick = { navController.navigate("StartGameRoute") },
                modifier = Modifier
                    .size(100.dp)
            ) {
                Text(stringResource(R.string.okButtonText))
            }
        }

}
