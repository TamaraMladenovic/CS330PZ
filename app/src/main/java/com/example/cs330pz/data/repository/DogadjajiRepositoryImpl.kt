package com.example.cs330pz.data.repository

import com.example.cs330pz.data.local.dao.DogadjajiDao
import com.example.cs330pz.domain.model.Dogadjaji
import com.example.cs330pz.domain.repository.DogadjajiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DogadjajiRepositoryImpl @Inject constructor(
    private val dogadjajiDao: DogadjajiDao
): DogadjajiRepository{
    override fun getAllDogadjaji(): Flow<List<Dogadjaji>> {
        return dogadjajiDao.getDogadjaji()
    }

    override fun getDogadjajById(dogadjajId: Int): Flow<Dogadjaji> {
        return dogadjajiDao.getDogadjajById(dogadjajId)
    }

    override fun getDogadjajiByDan(dogadjajDan: Int): Flow<List<Dogadjaji>> {
        return dogadjajiDao.getDogadjajByDan(dogadjajDan)
    }

}