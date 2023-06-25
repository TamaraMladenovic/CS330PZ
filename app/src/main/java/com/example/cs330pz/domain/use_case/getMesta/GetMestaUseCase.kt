package com.example.cs330pz.domain.use_case.getMesta

import com.example.cs330pz.common.Resource
import com.example.cs330pz.data.remote.dto.toMesto
import com.example.cs330pz.domain.model.Mesto
import com.example.cs330pz.domain.repository.MestoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMestaUseCase @Inject constructor(
    private val repository: MestoRepository
) {

    operator fun invoke(): Flow<Resource<List<Mesto>>> = flow {
        try{
            emit(Resource.Loading())
            val mesta = repository.getMesta().map { it.toMesto() }
            emit(Resource.Success(mesta))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error has occured!"))
        } catch (e: IOException){
            emit(Resource.Error("Coulndn't reach server. Check your internet connection!"))
        }
    }


}