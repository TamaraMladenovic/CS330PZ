package com.example.cs330pz.data.repository

import android.util.Log
import com.example.cs330pz.data.local.dao.BazaDao
import com.example.cs330pz.domain.model.Problemi
import com.example.cs330pz.domain.repository.ProblemiRepository
import javax.inject.Inject

class ProblemiRepositoryImpl @Inject constructor(
    private val bazaDao: BazaDao
): ProblemiRepository {
    override suspend fun insertProblem(problem: Problemi) {
        bazaDao.insertProblem(problem)
    }

}