package com.example.cs330pz.domain.use_case.databaseUseCase.getDogadjajById

import com.example.cs330pz.domain.model.Dogadjaji
import com.example.cs330pz.domain.repository.DogadjajiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDogadjajByIdUseCase @Inject constructor(
    private val repository: DogadjajiRepository
) {
    operator fun invoke(dogadjajId: Int): Flow<Dogadjaji> {
        return repository.getDogadjajById(dogadjajId)
    }
}