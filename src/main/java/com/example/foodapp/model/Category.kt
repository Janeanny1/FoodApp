package com.example.foodapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "Category")
data class Category(
    @PrimaryKey(autoGenerate = true)


    var pic: Int,

    @ColumnInfo(name = "title")
    var title: String
) : java.io.Serializable
