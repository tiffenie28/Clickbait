package com.example.clickbait

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clickbait.data.DataSource
import com.example.clickbait.ui.theme.ClickbaitTheme
import com.example.clickbait.model.Click


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           ClickbaitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClickbaitApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun ClickbaitApp() {
    Column {
        ClickbaitAppBar()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(DataSource.bait) { click ->
                ClickbaitCard(click)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickbaitAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name), // Use the app name string resource
            )
        }
    )
}



    @Composable
    fun ClickbaitCard(click: Click, modifier: Modifier = Modifier) {

        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Column(
                modifier = modifier.fillMaxWidth()
                ){

                Image(
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    painter = painterResource(click.image),
                    contentDescription = null
                )
                    Text(
                        text = stringResource(click.title),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Text(
                        text = stringResource(click.desc),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 8.dp),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    text = stringResource(click.time),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(start = 8.dp)
                )


                }
            }
        }



@Preview
@Composable
fun ClickbaitPreview() {
    ClickbaitTheme {
        ClickbaitCard(click = DataSource.bait[0])
    }
}

@Preview
    @Composable
    fun ClickbaitDarkThemePreview() {
        ClickbaitTheme(darkTheme = true) {
            ClickbaitApp()
        }
    }


