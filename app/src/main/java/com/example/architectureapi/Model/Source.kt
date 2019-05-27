package com.example.architectureapi.Model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sources")
data class Source (
    @PrimaryKey
    @NonNull
    val id: String,
    val name: String,
    val description: String
)