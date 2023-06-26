package com.example.cs330pz.presentation.dogadjaj_list

import com.example.cs330pz.domain.model.Dogadjaji

data class DogadjajState(
    val isLoading: Boolean = false,
    val dogadjaj: Dogadjaji ?= null,
    val dogadjaji: List<Dogadjaji> = emptyList(),
    val error: String = ""
)