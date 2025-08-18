package com.example.test123.model.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class Quote(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val statement: String,
    var isStarred: Boolean = false,
    var isHearted: Boolean = false
)


data class ApiResponse(
    val quote : String,
    val author : String,
    val category: String
)