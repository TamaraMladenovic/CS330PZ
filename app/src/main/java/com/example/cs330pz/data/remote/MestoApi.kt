package com.example.cs330pz.data.remote

import com.example.cs330pz.data.remote.dto.MestoDto
import retrofit2.http.GET

interface MestoApi {

    @GET("/mesta")
    suspend fun getMesta(): List<MestoDto>
}