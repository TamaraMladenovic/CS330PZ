package com.example.cs330pz.domain.repository

import com.example.cs330pz.domain.model.Problemi

interface ProblemiRepository {
    suspend fun insertProblem(problem: Problemi)
}