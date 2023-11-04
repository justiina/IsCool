package com.example.iscool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.iscool.ui.theme.IsCoolTheme
import com.example.iscool.ui.theme.Screens.StartGameScreen

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
    //Kun ottaa alla olevan osan pois kommenteista ja laittaa PictureWithButton osan kommentteihin niin saa näkyviin StartGameScreenin
    //StartGameScreen()
    PictureWithButton(modifier= Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun PictureWithButton(modifier: Modifier=Modifier) {
    var result by remember {
        mutableStateOf(5)
    }
    val imageResource = when(result) {
        1 -> R.drawable.iscool_01
        2 -> R.drawable.iscool_02
        3 -> R.drawable.iscool_03
        4 -> R.drawable.iscool_04
        5 -> R.drawable.iscool_05
        6 -> R.drawable.iscool_06
        7 -> R.drawable.notcool_01
        8 -> R.drawable.notcool_02
        9 -> R.drawable.notcool_03
        10 -> R.drawable.notcool_04
        11 -> R.drawable.notcool_05
        12 -> R.drawable.notcool_06
        else -> R.drawable.notcool_07
    }
    Column (
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "1",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Button(
            onClick = {result = (1..13).random()},
        ) {
            Text(stringResource(R.string.cool))
        }
    }
}



