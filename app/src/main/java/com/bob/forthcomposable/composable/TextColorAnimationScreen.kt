package com.bob.forthcomposable.composable

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TextColorAnimationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val infiniteTransition = rememberInfiniteTransition(label = "A")
        val color by infiniteTransition.animateColor(
            initialValue = Color.Yellow,
            targetValue = Color.Blue,
            animationSpec = InfiniteRepeatableSpec(
                tween(4000),
                repeatMode = RepeatMode.Reverse
            ), label = "B"
        )
        ComposeTextColor(backgroundColor = color)
    }
}

@Composable
fun ComposeTextColor(backgroundColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = backgroundColor)
    ) {
        Text(
            text = "Bob Sam",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTextColorAnimationScreen() {
    TextColorAnimationScreen()
}