package com.example.coffeemachine.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coffeemachine.ui.ViewModel
import com.example.coffeemachine.ui.components.CoffeeCard

@Composable
fun MenuScreen(
    viewModel: ViewModel
) {

    val uiState = viewModel.coffeeUiStateFlow.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.FixedSize(227.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement
            .spacedBy(
                space = 24.dp,
                alignment = Alignment.CenterHorizontally
            )
    ) {
        for (i in 0..30) {
            item {
                CoffeeCard(
                    coffeeUiState = uiState.value,
                    isFree = viewModel.isFree
                )
            }
        }
    }

}