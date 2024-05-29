package com.example.coffeemachine.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeemachine.R
import com.example.coffeemachine.data.MenuRepositoryImpl
import com.example.coffeemachine.data.SettingsRepositoryImpl
import com.example.coffeemachine.domain.model.Coffee
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val menuRepository: MenuRepositoryImpl,
    private val settingsRepository: SettingsRepositoryImpl
): ViewModel()  {

    lateinit var coffee: Coffee
        private set
    var coffeeUiStateFlow = MutableStateFlow(CoffeeUiState())
        private set
    var isCanSave by mutableStateOf(false)
        private set
    var isLoading by mutableStateOf(true)
        private set
    var isFree by mutableStateOf(false)
    var temperature = MutableStateFlow("80.0")
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            coffee = menuRepository.getCoffee()
            coffeeUiStateFlow.value = coffeeToUiState(coffee)
            delay(3000)
            checkIfIsFree()
            isLoading = false
        }
        viewModelScope.launch(Dispatchers.Default) {
            while (true) {
                temperature.value = "${(85..94).random()}.${(0..9).random()}"
                delay(1000L)
            }
        }
    }

    fun saveCoffee() {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.updateCoffee(uiStateToCoffee(coffeeUiStateFlow.value))
            coffee = menuRepository.getCoffee()
            isCanSave = false
        }
    }

    fun updateName(input: String) {
        if (input.isEmpty() ||
            input.last() in 'А'..'Я' ||
            input.last() in 'а'..'я' ||
            input.last() == ' ') {
            coffeeUiStateFlow.value = coffeeUiStateFlow.value.copy(name = input)
            checkIfCanSave()
            checkIfIsFree()
        }
    }

    fun updateCost(input: String) {
        val onlyDigits = input.filter { it.isDigit() }
        if (onlyDigits.isNotEmpty() && onlyDigits.first() == '0') {
            coffeeUiStateFlow.value = coffeeUiStateFlow.value.copy(cost = "0")
        } else {
            coffeeUiStateFlow.value = coffeeUiStateFlow.value.copy(cost = onlyDigits)
        }
        checkIfCanSave()
        checkIfIsFree()
    }

    fun updateImage(resId: Int) {
        coffeeUiStateFlow.value = coffeeUiStateFlow.value.copy(image = resId)
        checkIfCanSave()
    }

    fun exitWithoutSaving() {
        coffeeUiStateFlow.value = coffeeToUiState(coffee)
        isCanSave = false
    }

    private fun checkIfCanSave() {
        isCanSave = uiStateToCoffee(coffeeUiStateFlow.value) != coffee
    }

    private fun checkIfIsFree() {
        isFree = coffeeUiStateFlow.value.cost == "0" || coffeeUiStateFlow.value.cost.isEmpty()
    }

}

private fun coffeeToUiState(coffee: Coffee): CoffeeUiState {

    val imageId = if (coffee.image == "with_milk") {
        R.drawable.with_milk
    } else {
        R.drawable.mokka
    }

    return CoffeeUiState(
        name = coffee.name,
        cost = coffee.cost,
        image = imageId
    )
}

private fun uiStateToCoffee(uiState: CoffeeUiState): Coffee {

    val image = if (uiState.image == R.drawable.with_milk) {
        "with_milk"
    } else { "mokka" }

    return Coffee(
        id = 1,
        name = uiState.name,
        cost = uiState.cost,
        image = image
    )
}

