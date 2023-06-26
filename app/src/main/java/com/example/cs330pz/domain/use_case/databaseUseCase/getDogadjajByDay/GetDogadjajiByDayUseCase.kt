package com.example.cs330pz.domain.use_case.databaseUseCase.getDogadjajByDay

import com.example.cs330pz.domain.model.Dogadjaji
import com.example.cs330pz.domain.repository.DogadjajiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDogadjajiByDayUseCase @Inject constructor(
    private val repository: DogadjajiRepository
) {
    operator fun invoke(dogadjajDan: Int): Flow<List<Dogadjaji>> {
        return repository.getDogadjajiByDan(dogadjajDan)
    }
}