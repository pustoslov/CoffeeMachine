package com.example.coffeemachine

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.coffeemachine.ui.CoffeeApp
import com.example.coffeemachine.ui.theme.CoffeeMachineTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        enableEdgeToEdge()

        setContent {
            CoffeeMachineTheme {
                CoffeeApp()
            }
        }
    }
}