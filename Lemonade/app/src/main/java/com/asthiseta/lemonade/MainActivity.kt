package com.asthiseta.lemonade


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asthiseta.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    LemonadePreview()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    
    var currentStep by remember { mutableStateOf(1) }
    val message = when (currentStep) {
        1 -> stringResource(id = R.string.tap_lemon_tree)
        2 -> stringResource(id = R.string.tap_the_lemon)
        3 -> stringResource(id = R.string.tap_to_drink)
        4 -> stringResource(id = R.string.tap_to_empty_glass)
        else -> stringResource(id = R.string.tap_lemon_tree)
    }
    val contentDescription = when (currentStep) {
        1 -> stringResource(id = R.string.lemon_tree)
        2 -> stringResource(id = R.string.lemon)
        3 -> stringResource(id = R.string.glass_of_lemonade)
        4 -> stringResource(id = R.string.empty_glass)
        else -> stringResource(id = R.string.lemon_tree)
    }
    val imageResource = when (currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val randomSqueeze = (1..6).random()
    var lemonSqueezed by remember { mutableStateOf(0) }
    ImageAndTextLemonade(
        imageResource = imageResource,
        contentDescription = contentDescription,
        message = message,
        onImageClick = {
            if (currentStep == 2) {
                // Squeeze the lemon click randomSqueeze times,
            // then move to next step
                lemonSqueezed += 1
                if (lemonSqueezed >= randomSqueeze) {
                    currentStep += 1
                    lemonSqueezed = 0
                }

            } else {
                currentStep += 1
                if (currentStep > 4) {
                    currentStep = 1
                }
            }
        },
    )


}

@Composable
fun ImageAndTextLemonade(
    imageResource: Int,
    contentDescription: String,
    message: String,
    onImageClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .border(
                    width = 2.dp,
                    color = Color(100, 210, 200, 1),
                    shape = RoundedCornerShape(8.dp),
                ),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(204, 255, 234, 255),
            ),

            ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        onImageClick()

                    }

            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = message,
            modifier = Modifier.wrapContentSize(),
            fontSize = 18.sp,
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}