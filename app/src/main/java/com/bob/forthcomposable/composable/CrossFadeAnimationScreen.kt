package com.bob.forthcomposable.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bob.forthcomposable.R

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalAnimationApi::class
)
@Composable
fun CrossFadeAnimationScreen() {
    var showImage by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { showImage = !showImage },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Click Here")
        }

        AnimatedContent(
            targetState = showImage,
            transitionSpec = {
                scaleIn(tween(2000)) + fadeIn() togetherWith scaleOut(tween(2000))
            }, label = "A"
        ) {
            when (it) {
                true -> ComposeImage()
                false -> ComposeHeader()
            }
        }
    }
}

@Composable
fun ComposeImage() {
    Image(
        painter = painterResource(id = R.drawable.jujutsu_kaisen),
        contentDescription = "jujutsu_kaisen",
    )
}

@Composable
fun ComposeHeader() {
    Text(
        text = "Bob",
        fontSize = 20.sp,
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCrossFadeAnimationScreen() {
    CrossFadeAnimationScreen()
}