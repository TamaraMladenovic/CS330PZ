package com.example.cs330pz.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dogadjaji (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val naziv: String,
    val vreme: String,
    val opis: String,
    val lokacija: String,
    val dan: Int
)