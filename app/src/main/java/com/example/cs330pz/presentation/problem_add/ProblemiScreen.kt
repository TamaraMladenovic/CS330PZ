package com.example.cs330pz.presentation.problem_add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cs330pz.domain.model.Problemi
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProblemiScreen(
    navController: NavController,
    viewModel: ProblemViewModel = hiltViewModel()
){
    var ime = remember {
        mutableStateOf(TextFieldValue(""))
    }
    var tekst = remember {
        mutableStateOf((TextFieldValue("")))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = ime.value,
            onValueChange = { ime.value = it },
            label = { Text("Cocktail Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = tekst.value,
            onValueChange = { tekst.value = it },
            label = { Text("Tags (comma-separated)") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                val newProblem = Problemi(
                    id = 0,
                    ime = ime.value.text,
                    tekst = tekst.value.text
                )
                viewModel.addProblem(newProblem)
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Create")
        }
    }
    }
