package com.asthiseta.hbdapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asthiseta.hbdapp.ui.theme.HbdAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HbdAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "Happy Birthday Elza",
                        from = "From: Seta",
//                        modifier = Modifier
//                            .fillMaxSize()
                    )
                }
            }
        }
    }
}


@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier,
//                .background(color = Color.Green)
            contentScale =  ContentScale.Crop,
//            alpha = 0.5f,
        )
        GreetingText(message = message, from = from, modifier = modifier)
    }


}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(4.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = message, modifier = modifier,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,

            )
        Text(
            text = from,
            modifier = modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 36.sp,

            )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Light Theme")
@Composable
fun BirthdayCardPreview() {
    HbdAppTheme {
        GreetingImage(message = "Happy Birthday Elza", from = "From: Seta")
//        GreetingText(message = "Happy Birthday Elza", from = "From: Seta")
    }
}