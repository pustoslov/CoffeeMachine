package com.example.coffeemachine.di

import android.content.Context
import androidx.room.Room
import com.example.coffeemachine.data.CoffeeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): CoffeeDatabase =
        Room.databaseBuilder(appContext, CoffeeDatabase::class.java, "coffee.db")
            .createFromAsset("database/coffee.db")
            .build()

    @Singleton
    @Provides
    fun provideDao(database: CoffeeDatabase) = database.coffeeDao()

}