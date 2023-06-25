package com.example.cs330pz.data.repository

import com.example.cs330pz.data.remote.MestoApi
import com.example.cs330pz.data.remote.dto.MestoDto
import com.example.cs330pz.domain.repository.MestoRepository
import javax.inject.Inject

class MestoRepositoryImpl @Inject constructor(
    private val api: MestoApi
) : MestoRepository {
    override suspend fun getMesta(): List<MestoDto> {
        return api.getMesta()
    }
}