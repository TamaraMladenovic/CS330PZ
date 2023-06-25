package com.example.cs330pz.data.remote.dto

import com.example.cs330pz.domain.model.Mesto

data class MestoDto(
    val naziv: String,
    val lokacija: String,
    val tip: String,
    val opis: String
)

fun MestoDto.toMesto(): Mesto{
    return Mesto(
        naziv = naziv,
        lokacija = lokacija,
        tip = tip,
        opis = opis
    )
}