package com.example.cs330pz.presentation.nav_bar

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@HiltViewModel
class NavBarViewModel @Inject constructor(

): ViewModel() {
    var tabIndex by mutableStateOf(3)
    private val _state = mutableStateOf(NavBarState())
    val state: State<NavBarState> = _state

    init{
        tabIndex = 0
    }

    fun setShown(selected: Int){
        when(selected){
            0 -> {
                _state.value = _state.value.copy(
                    isMainPage = true,
                    localDatabase = true,
                    dialog = false
                )
            }
            1 -> {
                _state.value = _state.value.copy(
                    isMainPage = false,
                    localDatabase = false,
                    dialog = false
                )
            }
            else -> {
                _state.value = _state.value.copy(
                    isMainPage = false,
                    localDatabase = true,
                    dialog = false
                )
            }
        }
    }
}