package com.example.coffeemachine.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeemachine.domain.model.Coffee

@Database(entities = [Coffee::class], version = 1, exportSchema = true)
abstract class CoffeeDatabase: RoomDatabase() {
    abstract fun coffeeDao(): CoffeeDao
}