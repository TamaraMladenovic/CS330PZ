package com.example.cs330pz.presentation.mesto_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs330pz.common.Resource
import com.example.cs330pz.domain.use_case.getMesta.GetMestaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MestoListViewModel @Inject constructor(
    private val getMestaUseCase: GetMestaUseCase
) : ViewModel() {
    private val _state = mutableStateOf<MestoListState>(MestoListState())
    val state: State<MestoListState> = _state

    init{
        getMesta()
    }

    private fun getMesta(){
        getMestaUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = MestoListState(mesto = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MestoListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = MestoListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}