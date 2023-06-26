package com.example.cs330pz.presentation.dogadjaj_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs330pz.common.Constants
import com.example.cs330pz.domain.use_case.databaseUseCase.getDogadjajById.GetDogadjajByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DogadjajDetailViewModel @Inject constructor(
    private val getDogadjajByIdUseCase: GetDogadjajByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private val _state = mutableStateOf(DogadjajDetailState())
    val state: State<DogadjajDetailState> = _state

    init{
        savedStateHandle.get<String>(Constants.DOGADJAJ_ID)?.let { dogadjajId ->
            getDogadjajiById(dogadjajId.toInt())
        }
    }

    private fun getDogadjajiById(dogadjajId: Int){
        getDogadjajByIdUseCase(dogadjajId).onEach { result ->
            _state.value = state.value.copy(dogadjaj = result)
        }.launchIn(viewModelScope)
    }
}