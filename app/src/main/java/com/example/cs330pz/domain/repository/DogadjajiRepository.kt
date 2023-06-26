package com.example.cs330pz.domain.repository

import com.example.cs330pz.domain.model.Dogadjaji
import kotlinx.coroutines.flow.Flow

interface DogadjajiRepository {

    fun getAllDogadjaji(): Flow<List<Dogadjaji>>
    fun getDogadjajById(dogadjajId: Int): Flow<Dogadjaji>
    fun getDogadjajiByDan(dogadjajDan: Int): Flow<List<Dogadjaji>>

}