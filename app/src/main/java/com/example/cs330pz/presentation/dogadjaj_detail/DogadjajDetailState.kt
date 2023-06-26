package com.example.cs330pz.presentation.dogadjaj_detail

import com.example.cs330pz.common.Resource
import com.example.cs330pz.domain.model.Dogadjaji

data class DogadjajDetailState(
    val isLoading: Boolean = false,
    val dogadjaj: Dogadjaji? = null,
    val dogadjaji: List<Dogadjaji> = emptyList(),
    val error: String = ""
) {
}