package com.example.cs330pz.presentation.dogadjaj_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.cs330pz.presentation.Screen
import com.example.cs330pz.presentation.dogadjaj_list.DogadjajiViewModel

@Composable
fun DogadjajMainItemList(
    navController: NavController,
    viewModel: DogadjajiViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(vertical = 20.dp)){
            itemsIndexed(state.dogadjaji){index, dogadjaj ->
                DogadjajiMainItem(
                    dogadjaj = dogadjaj,
                    onItemClick = {
                        navController.navigate(Screen.DogadjajiDetailScreen.route + "/${dogadjaj.id}")
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}