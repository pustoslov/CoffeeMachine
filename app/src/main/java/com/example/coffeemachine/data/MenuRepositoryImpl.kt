package com.example.coffeemachine.data

import com.example.coffeemachine.domain.repository.MenuRepository
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val coffeeDao: CoffeeDao
): MenuRepository {
    override suspend fun getCoffee() = coffeeDao.getCoffee()
}