package com.example.marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.marvel.Navigation.AppNavigation
import com.example.marvel.Navigation.BottomNavigationBar
import com.example.marvel.Navigation.TopBar
import com.example.marvel.Screen.InfoScreen
import com.example.marvel.Screen.SettingsScreen
import com.example.marvel.Screen.SearchScreen
import com.example.marvel.ui.theme.DogTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            navController = rememberNavController()
            AppNavigation(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutAppScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    )
    { innerPadding ->
        NavHost(navController, startDestination = "home") {
            composable("home") {
                AboutAppContent(
                    modifier = Modifier
                        .padding(innerPadding)
                        .verticalScroll(state = rememberScrollState()),
                    appDescription = listOf(
                        R.string.dog_1,
                        R.string.dog_2,
                        R.string.dog_3,
                        R.string.dog_4,
                        R.string.dog_5,
                        R.string.dog_6
                    )
                )
            }
            composable("settings") {
                SettingsScreen()
            }
            composable("search") {
                SearchScreen()
            }
            composable("results") {
                InfoScreen()
            }
        }
    }
}

@Composable
fun AboutAppContent(modifier: Modifier = Modifier, appDescription: List<Int>) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Poster()
            AppDescription(
                appDescription = appDescription
            )
        }
    }
}

@Composable
fun Poster() {
    Image(
        painter = painterResource(id = R.drawable.blue_dog),
        contentDescription = null,
        contentScale = ContentScale.FillWidth)
}

@Composable
fun AppDescription(modifier: Modifier = Modifier, appDescription: List<Int>) {
    val gradientColors = listOf(Color(0,0,128), Color.Cyan)
    Column (
        modifier = modifier.background(color = Color.White)
    ) {
        Text(
            text = stringResource(R.string.app_description),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            ),
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.padding(top = 15.dp, start = 10.dp),
            textAlign = TextAlign.Center
        )

        RoundElementsRow(modifier = modifier.padding(top = 10.dp))
        for (content in appDescription) {
            DescriptionCard(text = content)
        }

    }
}

@Composable
fun MatchResult(
    leftTeam: String,
    leftScore: Int,
    rightTeam: String,
    rightScore: Int
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(10.dp)
    ) {
        Text(
            text = leftTeam,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "$leftScore : $rightScore",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = rightTeam,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun DescriptionCard(
    @DrawableRes
    @StringRes text: Int,
    modifier: Modifier = Modifier,
){
    Surface (
        shape = CircleShape,
        modifier = modifier.padding(10.dp),
        color = Color(227,217,255)
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        )
        {
            Image(painter = painterResource(id = R.drawable.image_1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = stringResource(id = text),
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = modifier.padding(20.dp),
            )
        }
    }
}

@Composable
fun RoundElementsRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(horizontal = 25.dp),
    ) {
        items(appData) { item ->
            RoundElements(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
fun RoundElements(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0,0,128),
        )
    }
}

private val appData = listOf(
    R.drawable.news to R.string.round_item_text1,
    R.drawable.pic2 to R.string.round_item_text2,
    R.drawable.pic5 to R.string.round_item_text3,
    R.drawable.pic3 to R.string.round_item_text4,
    R.drawable.pic4 to R.string.round_item_text5,

    ).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DogTheme {
        AboutAppScreen()
    }
}

