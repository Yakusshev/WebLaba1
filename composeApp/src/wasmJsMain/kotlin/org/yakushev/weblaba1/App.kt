package org.yakushev.weblaba1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.yakushev.weblaba1.components.TextCaption
import org.yakushev.weblaba1.components.TextHyperLink
import weblaba1.composeapp.generated.resources.Res
import weblaba1.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            modifier = Modifier
                                .padding(start = 16.dp),
                            text = "Yakushev",
                        )
                    },
                    actions = {
//                        Text(
//                            modifier = Modifier
//                                .height(IntrinsicSize.Max)
//                                .clickable(onClick = viewModel::onClearClicked)
//                                .padding(end = 24.dp, start = 24.dp),
//                            text = "Очистить",
//                            color = MaterialTheme.colorScheme.primary,
//                        )
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding).padding(horizontal = 24.dp),
            ) {
                TextHyperLink(text = "telegram", url = "https://t.me/yakkshv")
                TextHyperLink(text = "tiktok", url = "https://tiktok.com/@yakkusshev")
                TextHyperLink(text = "instagram", url = "https://instagram.com/yakkusshev")
                TextHyperLink(text = "youtube", url = "https://www.youtube.com/@yakusshev")
            }
        }
    }
}

@Composable
fun Asd() {
    var showContent by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { showContent = !showContent }) {
            Text("click me!")
        }
        AnimatedVisibility(showContent) {
            val greeting = remember { Greeting().greet() }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(Res.drawable.compose_multiplatform), null)
                Text("Compose: $greeting")
            }
        }
    }
}