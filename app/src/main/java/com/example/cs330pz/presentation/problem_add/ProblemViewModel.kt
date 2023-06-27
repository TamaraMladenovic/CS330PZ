package com.example.cs330pz.presentation.problem_add

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs330pz.domain.model.Problemi
import com.example.cs330pz.domain.use_case.databaseUseCase.addProblem.InsertProblemUseCase
import com.example.cs330pz.presentation.dogadjaj_list.DogadjajState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProblemViewModel @Inject constructor(
    private val insertProblem: InsertProblemUseCase
): ViewModel(){

    fun addProblem(problem: Problemi){
        GlobalScope.launch {
            insertProblem(problem)
        }
    }
}