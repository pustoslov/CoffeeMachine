package com.example.coffeemachine.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffeemachine.ui.components.TopBar
import com.example.coffeemachine.ui.navigation.NavGraph
import com.example.coffeemachine.ui.navigation.NavigationScreen
import com.example.coffeemachine.ui.screens.LoadingScreen
import com.example.coffeemachine.ui.screens.MenuScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CoffeeApp(
    viewModel: ViewModel = viewModel()
) {

    val navController = rememberNavController()

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {

    }

    if (viewModel.isLoading) {
        LoadingScreen()
    } else {
        Column {
            TopBar(
                viewModel = viewModel,
                onClick = {
                    if (navController.currentBackStackEntry?.destination?.route
                        == NavigationScreen.Menu.name) {
                        navController.navigate(NavigationScreen.Settings.name)
                    } else {
                        navController.popBackStack()
                        viewModel.exitWithoutSaving()
                    }
                }
            )
            NavGraph(viewModel = viewModel, navController = navController)
        }
    }

}