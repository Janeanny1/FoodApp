package com.example.foodapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Food")
data class Food(
    @PrimaryKey(autoGenerate = true)

    var pic: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "amount")
    var amount: String
)
