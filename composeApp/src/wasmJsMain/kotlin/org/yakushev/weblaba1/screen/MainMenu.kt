package org.yakushev.weblaba1.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.yakushev.weblaba1.components.TextRow
import org.yakushev.weblaba1.navigation.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenu(
    navController: NavHostController,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp),
                        text = "Yakushev",
                    )
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            TextRow(text = "Visit Card (Laba 1)") { navController.navigate(Route.VISIT_CARD) }
            TextRow(text = "Registration (Laba 2)") { navController.navigate(Route.REGISTRATION) }
            TextRow(text = "Laba 3") { navController.navigate(Route.LABA3) }
        }
    }
}