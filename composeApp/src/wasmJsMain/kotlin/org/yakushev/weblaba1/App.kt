package org.yakushev.weblaba1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import weblaba1.composeapp.generated.resources.Res
import weblaba1.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        Asd()
//        Scaffold(modifier = Modifier.fillMaxSize(),
//            topBar = {
//                TopAppBar(
//                    title = {
//                        Text(
//                            modifier = Modifier
//                                .padding(start = 16.dp),
//                            text = "Yakushev",
//                        )
//                    },
//                    actions = {
////                        Text(
////                            modifier = Modifier
////                                .height(IntrinsicSize.Max)
////                                .clickable(onClick = viewModel::onClearClicked)
////                                .padding(end = 24.dp, start = 24.dp),
////                            text = "Очистить",
////                            color = MaterialTheme.colorScheme.primary,
////                        )
//                    }
//                )
//            }
//        ) { innerPadding ->
//            Column(
//                modifier = Modifier.padding(innerPadding),
//            ) {
//
//            }
//        }
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