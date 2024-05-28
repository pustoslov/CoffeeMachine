package com.example.coffeemachine.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coffeemachine.ui.ViewModel
import com.example.coffeemachine.ui.screens.MenuScreen
import com.example.coffeemachine.ui.screens.SettingsScreen

@Composable
fun NavGraph(
    viewModel: ViewModel,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Menu.name
    ) {
        composable(NavigationScreen.Menu.name) {
            MenuScreen(viewModel = viewModel)
        }
        composable(NavigationScreen.Settings.name) {
            SettingsScreen(
                viewModel = viewModel,
                onSaveClick = { navController.popBackStack() }
            )
        }
    }
}