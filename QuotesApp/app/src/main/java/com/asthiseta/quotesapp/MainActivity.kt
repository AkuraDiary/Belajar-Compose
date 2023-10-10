package com.asthiseta.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asthiseta.quotesapp.data.DataSource
import com.asthiseta.quotesapp.model.Affirmation
import com.asthiseta.quotesapp.ui.theme.QuotesAppTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyQuotesApps()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyQuotesApps() {
    AffirmationList(
        DataSource().loadAffirmations()
    )
}


@Composable
fun AffirmationList(affirmationList : List<Affirmation>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(affirmationList){affirmationItem ->
            AffirmationCardLayout(
                affirmation = affirmationItem,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}

@Preview(showBackground =false)
@Composable
fun AffirmationCardPreview(){
    AffirmationCardLayout(
        Affirmation(
        stringResourceId = R.string.affirmation1,
        imageResourceId = R.drawable.image1
        )
    )
}

@Composable
fun AffirmationCardLayout(
    affirmation: Affirmation,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(194.dp)
            )

            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}