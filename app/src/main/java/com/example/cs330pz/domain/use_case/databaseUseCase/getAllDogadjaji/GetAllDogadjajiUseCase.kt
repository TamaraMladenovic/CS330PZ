package com.example.cs330pz.domain.use_case.databaseUseCase.getAllDogadjaji

import com.example.cs330pz.domain.model.Dogadjaji
import com.example.cs330pz.domain.repository.DogadjajiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllDogadjajiUseCase @Inject constructor(
    private val repository: DogadjajiRepository
) {
    operator fun invoke(): Flow<List<Dogadjaji>>{
        return repository.getAllDogadjaji()
    }
}