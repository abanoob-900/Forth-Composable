package com.bob.forthcomposable.composable

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebViewScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Bob | WebView",
                        color = Color.Black
                    )
                },
                modifier = Modifier.background(
                    color = Color(0xff0f9d58)
                )
            )
        },
        content = {
            Surface {
                Column {

                    // Declare a string that contains a url
                    val mUrl = "https://www.geeksforgeeks.org"

                    // Adding a WebView inside AndroidView
                    // with layout as full screen
                    AndroidView(factory = {
                        WebView(it).apply {
                            layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT
                            )
                            webViewClient = WebViewClient()
                            loadUrl(mUrl)
                        }
                    }, update = {
                        it.loadUrl(mUrl)
                    })

                    val re = remember {

                    }
                }
            }
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewWebViewScreen() {
    WebViewScreen()
}