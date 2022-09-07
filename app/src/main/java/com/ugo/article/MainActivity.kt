package com.ugo.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArticleWithImage(
                        stringResource(id = R.string.title),
                        stringResource(id = R.string.para_one),
                        stringResource(id = R.string.para_two)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleText(title: String, paraOne: String, paraTwo: String) {
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                .wrapContentWidth(Alignment.Start)

        )
        Text(
            text = paraOne,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paraTwo,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ArticleWithImage(title: String, paraOne: String, paraTwo: String) {
    val image = painterResource(id = R.drawable.ic_article_img)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
        ArticleText(title = title, paraOne = paraOne, paraTwo = paraTwo)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArticleTheme {
        ArticleWithImage(
            stringResource(id = R.string.title),
            stringResource(id = R.string.para_one),
            stringResource(id = R.string.para_two)
        )
    }
}