package com.ugo.article

import android.os.Bundle
import android.text.style.ClickableSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ugo.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleTheme {
                // A surface container using the 'background' color from the theme
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    LemonadeScreens(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeScreens(modifier: Modifier = Modifier) {
    var counter by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
//    val imageResource = when(counter) {
//        1 -> R.drawable.lemon_tree
//        2 -> R.drawable.lemon_squeeze
//        3 -> R.drawable.lemon_drink
//        4 -> R.drawable.lemon_restart
//        else -> R.drawable.lemon_tree
//    }
//    val stringText = when(counter) {
//        1 -> R.string.first
//        2 -> R.string.second
//        3 -> R.string.third
//        4 -> R.string.fourth
//        else -> R.string.first
//    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(counter) {
            1 -> {
                LemonTextWithImage(
                    label = stringResource(id = R.string.first), 
                    image = painterResource(id = R.drawable.lemon_tree)
                ) {
                    counter = 2
                    squeezeCount = (2..4).random()
                } 
            }

            2 -> {
                LemonTextWithImage(
                    label = stringResource(id = R.string.second), 
                    image = painterResource(id = R.drawable.lemon_squeeze)
                ) {
                    squeezeCount--
                    if (squeezeCount == 0) {
                        counter = 3
                    }
                }
            }

            3 -> {
                LemonTextWithImage(
                    label = stringResource(id = R.string.third),
                    image = painterResource(id = R.drawable.lemon_drink)
                ) {
                    counter = 4
                }
            }

            4 -> {
                LemonTextWithImage(
                    label = stringResource(id = R.string.third),
                    image = painterResource(id = R.drawable.lemon_restart)
                ) {
                    counter = 1
                }
            }
        }

    }
}

@Composable
fun LemonTextWithImage(label: String, image: Painter, onClickStarted: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = label,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = image,
            contentDescription = "imageOne",
            modifier = Modifier
                .wrapContentSize()
                .border(
                    width = 2.dp,
                    color = Color(red = 105, green = 205, blue = 216),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable {
                    onClickStarted()
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArticleTheme {
        LemonadeApp()
    }
}