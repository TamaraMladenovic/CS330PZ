package com.example.cs330pz.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.cs330pz.domain.model.Dogadjaji
import com.example.cs330pz.domain.model.Problemi
import kotlinx.coroutines.flow.Flow

@Dao
interface BazaDao {

    @Query("SELECT * FROM dogadjaji")
    fun getDogadjaji(): Flow<List<Dogadjaji>>

    @Query("SELECT * FROM dogadjaji WHERE id= :dogadjajId")
    fun getDogadjajById(dogadjajId: Int): Flow<Dogadjaji>

    @Query("SELECT * FROM dogadjaji WHERE dan= :dogadjajDan")
    fun getDogadjajByDan(dogadjajDan: Int): Flow<List<Dogadjaji>>

    @Upsert
    suspend fun insertProblem(problem: Problemi)
}