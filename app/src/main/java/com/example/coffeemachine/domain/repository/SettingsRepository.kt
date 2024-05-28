package com.example.coffeemachine.domain.repository

import com.example.coffeemachine.domain.model.Coffee

interface SettingsRepository {
    suspend fun updateCoffee(coffee: Coffee)
}