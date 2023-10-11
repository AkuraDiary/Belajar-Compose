package com.asthiseta.courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asthiseta.courseapp.data.model.Topic
import com.asthiseta.courseapp.ui.theme.CourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MyCourseAppMainlayout("Android")
                }
            }
        }
    }
}

@Composable
fun MyCourseAppMainlayout(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun CardCourseLayout(
    topic: Topic,
    modifier: Modifier = Modifier
) {

    Card(
//        modifier = modifier.height(64.dp).wrapContentSize()
    )
    {
        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box{
                Image(
                    painter = painterResource(topic.drawableResId),
                    contentDescription = stringResource(topic.stringResId),
                    modifier = Modifier.size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }


            Column(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(topic.stringResId),
                    style = MaterialTheme.typography.bodyMedium,
                )

                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {

                    Image(
                        painter = painterResource(R.drawable.grain),
                        contentDescription = null
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CardCourseLayoutPreview() {
    CardCourseLayout(
        topic = Topic(
            stringResId = R.string.architecture,
            availableCourses = 123,
            drawableResId = R.drawable.crafts
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyCourseAppLayoutPreview() {
    CourseAppTheme {
        MyCourseAppMainlayout("Android")
    }
}