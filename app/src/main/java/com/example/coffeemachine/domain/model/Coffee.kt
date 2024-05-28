package com.example.coffeemachine.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coffee")
data class Coffee(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val cost: String,
    val image: String
)
