package com.example.cs330pz.data.repository

import com.example.cs330pz.data.local.dao.BazaDao
import com.example.cs330pz.domain.model.Dogadjaji
import com.example.cs330pz.domain.repository.DogadjajiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DogadjajiRepositoryImpl @Inject constructor(
    private val bazaDao: BazaDao
): DogadjajiRepository{
    override fun getAllDogadjaji(): Flow<List<Dogadjaji>> {
        return bazaDao.getDogadjaji()
    }

    override fun getDogadjajById(dogadjajId: Int): Flow<Dogadjaji> {
        return bazaDao.getDogadjajById(dogadjajId)
    }

    override fun getDogadjajiByDan(dogadjajDan: Int): Flow<List<Dogadjaji>> {
        return bazaDao.getDogadjajByDan(dogadjajDan)
    }

}