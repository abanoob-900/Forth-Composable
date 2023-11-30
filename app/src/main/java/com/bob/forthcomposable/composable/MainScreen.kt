package com.bob.forthcomposable.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bob.forthcomposable.R

@Composable
fun MainScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (button, textHello, fab) = createRefs()

        Button(onClick = {},
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top); bottom.linkTo(parent.bottom)
                start.linkTo(parent.start); end.linkTo(parent.end)
                horizontalBias = 0.5f
            }) {
            Text(text = "Bob", color = Color.Yellow)
        }
        FloatingActionButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(fab) {
                    bottom.linkTo(parent.bottom, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                },
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_auto_mode_24),
                contentDescription = "baseline_auto_mode_24"
            )
        }
        Text(
            text = "Hello, android with constraint.",
            color = Color.Black,
            modifier = Modifier.constrainAs(textHello) {
                top.linkTo(button.bottom, 16.dp)
                bottom.linkTo(fab.top, 16.dp)
                start.linkTo(button.start)
                end.linkTo(button.end)
                verticalBias = 0.0F
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}