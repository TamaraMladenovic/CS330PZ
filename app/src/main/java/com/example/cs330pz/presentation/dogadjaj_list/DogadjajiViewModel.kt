package com.example.cs330pz.presentation.dogadjaj_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs330pz.common.Constants
import com.example.cs330pz.common.Resource
import com.example.cs330pz.domain.model.Dogadjaji
import com.example.cs330pz.domain.use_case.databaseUseCase.getAllDogadjaji.GetAllDogadjajiUseCase
import com.example.cs330pz.domain.use_case.databaseUseCase.getDogadjajByDay.GetDogadjajiByDayUseCase
import com.example.cs330pz.domain.use_case.databaseUseCase.getDogadjajById.GetDogadjajByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DogadjajiViewModel @Inject constructor(
    private val getAllDogadjajiUseCase: GetAllDogadjajiUseCase,
    private val getDogadjajiByDayUseCase: GetDogadjajiByDayUseCase,
    private val getDogadjajByIdUseCase: GetDogadjajByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(DogadjajState())
    val state: State<DogadjajState> = _state

    private var getDogadjajiJob: Job? = null


    init{
        getDogadjaji()
        savedStateHandle.get<String>(Constants.DOGADJAJ_DAN)?.let { dogadjajDan ->
            getDogadjajiByDan(dogadjajDan.toInt())
        }
    }

    private fun getDogadjaji(){
        getDogadjajiJob?.cancel()
        getDogadjajiJob = getAllDogadjajiUseCase().onEach { result ->
            _state.value = state.value.copy(dogadjaji = result)
        }.launchIn(viewModelScope)
    }

    fun getDogadjajiByDan(dogadjajDan: Int){
        getDogadjajiByDayUseCase(dogadjajDan).onEach { result ->
            _state.value = state.value.copy(dogadjaji = result)
        }.launchIn(viewModelScope)
    }
}