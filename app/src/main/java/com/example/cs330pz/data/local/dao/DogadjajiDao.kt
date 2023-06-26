package com.example.cs330pz.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cs330pz.domain.model.Dogadjaji
import kotlinx.coroutines.flow.Flow

@Dao
interface DogadjajiDao {

    @Query("SELECT * FROM dogadjaji")
    fun getDogadjaji(): Flow<List<Dogadjaji>>

    @Query("SELECT * FROM dogadjaji WHERE id= :dogadjajId")
    fun getDogadjajById(dogadjajId: Int): Flow<Dogadjaji>

    @Query("SELECT * FROM dogadjaji WHERE dan= :dogadjajDan")
    fun getDogadjajByDan(dogadjajDan: Int): Flow<List<Dogadjaji>>
}