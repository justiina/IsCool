package com.example.iscool.ui.theme.Screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.iscool.R
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.unit.sp
@Composable
fun PlayGameScreen(
    navController: NavHostController
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Add spacing between buttons
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(
                onClick = { navController.navigate("StartGameRoute") },
                modifier = Modifier
                    .size(100.dp)
            ) {
                Text(stringResource(R.string.cancelButtonText))
            }
            Button(
                onClick = { navController.navigate("EndGameRoute") },
                modifier = Modifier
                    .size(100.dp)
            ) {
                Text(stringResource(R.string.quitGameButtonText))
            }
        }
        PictureWithButton(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}
@Composable
fun PictureWithButton(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var result by remember {
        mutableStateOf(5)
    }
    var points by remember {
        mutableStateOf(0)
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
    var buttonClicked by remember { mutableStateOf(false) }
    val updatedResult = rememberUpdatedState(result)

    // Function to generate random numbers so that same number never comes twice in a row
    // (i.e. same image is not shown twice in a row)
    fun generateRandomNumber(range: IntRange, previousNumber: Int?): Int {
        var newNumber: Int
        do {
            newNumber = range.random()
        } while (newNumber == previousNumber)
        return newNumber
    }

    // Loop to show images in gradually reducing interval
    val handler = Handler(Looper.getMainLooper())
    DisposableEffect(Unit) {
        val runnable = object : Runnable {
            var delayMillis = 3000L // Initial interval is 3 seconds
            var previousNum: Int? = null

            override fun run() {
                if ((!buttonClicked && updatedResult.value < 7) || (buttonClicked && updatedResult.value > 6)) {
                    navController.navigate("EndGameRoute")
                } else {
                    buttonClicked = false
                }
                result = generateRandomNumber(1..13, previousNum)
                previousNum = result

                // Reduce the interval gradually by 100 milliseconds
                delayMillis -= 100
                // Limit to a minimum interval of 400 milliseconds
                delayMillis = delayMillis.coerceAtLeast(400)

                handler.postDelayed(this, delayMillis)
                points += 1
            }
        }
        handler.postDelayed(runnable, 3000) // Start with an initial interval of 3 seconds
        onDispose {
            handler.removeCallbacksAndMessages(null)
        }
    }

    Column (
        modifier = modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "1",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 8.dp)
        )
        Button(
            onClick = { buttonClicked = true },
            modifier = Modifier
                .clip(CircleShape)
                .size(150.dp)
        ) {
            Text(stringResource(R.string.cool))
        }
        Text("Points: $points", fontSize = 24.sp)
    }
}
