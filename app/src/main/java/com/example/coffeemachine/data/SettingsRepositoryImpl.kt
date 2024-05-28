package com.example.coffeemachine.data

import com.example.coffeemachine.domain.model.Coffee
import com.example.coffeemachine.domain.repository.SettingsRepository
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val coffeeDao: CoffeeDao
): SettingsRepository {
    override suspend fun updateCoffee(coffee: Coffee) = coffeeDao.updateCoffee(coffee)
}