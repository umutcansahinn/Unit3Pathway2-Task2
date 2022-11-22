@file:OptIn(ExperimentalFoundationApi::class)

package com.umutcansahin.unit3pathway2task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umutcansahin.unit3pathway2task2.data.DataSource
import com.umutcansahin.unit3pathway2task2.model.Topic
import com.umutcansahin.unit3pathway2task2.ui.theme.Unit3Pathway2Task2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit3Pathway2Task2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicGrid()
                }
            }
        }
    }
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        cells =GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp),
        content = {
            items(DataSource.topics) { topic->
                TopicCard(topic = topic, modifier = modifier)
            }
        }
    )
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        elevation = 4.dp
    ) {
        Row {
            Image(
                painter = painterResource(id = topic.imageRes),
                contentDescription = null,
                modifier = modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            Column {
                Text(
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.body2,
                    modifier = modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_grain_24),
                        contentDescription = null,
                        modifier = modifier
                            .padding(start = 16.dp)
                            .size(12.dp)
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.caption,
                        modifier = modifier
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TopicCardPreview() {
    Unit3Pathway2Task2Theme {
        val topic = Topic(R.string.photography,321,R.drawable.photography)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopicCard(topic = topic)
        }
    }
}