package com.example.cs330pz.domain.use_case.databaseUseCase.addProblem

import com.example.cs330pz.domain.model.Problemi
import com.example.cs330pz.domain.repository.ProblemiRepository
import javax.inject.Inject

class InsertProblemUseCase @Inject constructor(
    private val repository: ProblemiRepository
) {
    operator suspend fun invoke(problem: Problemi){
        repository.insertProblem(problem)
    }
}