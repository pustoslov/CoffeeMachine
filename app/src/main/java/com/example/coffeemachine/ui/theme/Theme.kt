package com.example.coffeemachine.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val MainColorScheme = darkColorScheme(
    primary = Orange,
    surface = Black,
    background = Black
)

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */


@Composable
fun CoffeeMachineTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MainColorScheme,
        typography = Typography,
        content = content
    )
}