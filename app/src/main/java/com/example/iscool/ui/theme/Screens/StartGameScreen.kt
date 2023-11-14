package com.example.iscool.ui.theme.Screens

import android.widget.TextView
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource

@Composable
fun StartGameScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .fillMaxSize() // Täyttää koko ruudun
            .padding(top = 50.dp)
            .padding(24.dp),
        verticalArrangement = Arrangement.Top, // Asettaa sisällön yläosaan
        horizontalAlignment = Alignment.CenterHorizontally // Asettaa sisällön keskelle vaakasuunnassa
    ) {
        val image = painterResource(R.drawable.logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(top = 40.dp)
        )
        Text(
            text = stringResource(R.string.instructionsText),
            modifier = Modifier
                .padding(top = 100.dp) // Lisää yläreunaan paddingia

        )
        Spacer(modifier = Modifier.weight(2f)) // Käyttää 2/3 tilasta ennen nappia
        Button(
            onClick = { navController.navigate("PlayGameRoute") },
            modifier = Modifier
                .size(100.dp) // Asettaa napin koon
        ) {
            Text(stringResource(R.string.playButtonText))
        }
        Spacer(modifier = Modifier.weight(1f)) // Käyttää 1/3 tilasta napin jälkeen
    }
}