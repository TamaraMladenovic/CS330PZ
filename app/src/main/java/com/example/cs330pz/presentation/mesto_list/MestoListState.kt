package com.example.cs330pz.presentation.mesto_list

import com.example.cs330pz.domain.model.Mesto

data class MestoListState(
    val isLoading: Boolean = false,
    val mesto: List<Mesto> = emptyList(),
    val error: String = ""
)
