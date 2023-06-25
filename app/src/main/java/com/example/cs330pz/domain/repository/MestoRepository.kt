package com.example.cs330pz.domain.repository

import com.example.cs330pz.data.remote.dto.MestoDto

interface MestoRepository {

    suspend fun getMesta(): List<MestoDto>

}