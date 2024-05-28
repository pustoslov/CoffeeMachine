package com.example.coffeemachine.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.coffeemachine.domain.model.Coffee
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeDao {

    @Update
    suspend fun updateCoffee(coffee: Coffee)

    @Query("Select * from coffee where id = 1")
    suspend fun getCoffee(): Coffee

}