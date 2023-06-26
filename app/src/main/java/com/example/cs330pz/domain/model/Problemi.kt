package com.example.cs330pz.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Problemi(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val ime: String,
    val tekst: String
)
