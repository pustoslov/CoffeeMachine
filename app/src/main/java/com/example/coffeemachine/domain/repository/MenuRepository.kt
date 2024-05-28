package com.example.coffeemachine.domain.repository

import com.example.coffeemachine.domain.model.Coffee

interface MenuRepository {
    suspend fun getCoffee(): Coffee
}