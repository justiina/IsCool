package com.example.iscool.ui.theme.Screens

import androidx.compose.foundation.layout.Column
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
fun StartGameScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    Column(
    ) {
        Text(
            text = "StartGameScreen",
        )
        Button(
            onClick = {navController.navigate("PlayGameRoute")},
            modifier = Modifier
                .size(100.dp)
        ) {
            Text(stringResource(R.string.playButtonText))
        }
    }

}