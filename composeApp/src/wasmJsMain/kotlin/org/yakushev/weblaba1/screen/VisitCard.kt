package org.yakushev.weblaba1.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.yakushev.weblaba1.components.TextHyperLink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisitCard(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp),
                        text = "Yakushev.MainMenu.VisitCard",
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
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