package org.yakushev.weblaba1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.yakushev.weblaba1.screen.MainMenu
import org.yakushev.weblaba1.screen.Registration
import org.yakushev.weblaba1.screen.VisitCard

@Composable
fun SetupNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Route.MAIN_MENU,
    ) {
        composable(route = Route.MAIN_MENU) { MainMenu(navController = navController) }
        composable(route = Route.VISIT_CARD) { VisitCard(navController = navController) }
        composable(route = Route.REGISTRATION) { Registration(navController = navController) }
        composable(route = Route.LABA3) {  }
    }
}