package com.example.cs330pz.presentation.dogadjaj_list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cs330pz.presentation.Screen
import com.example.cs330pz.presentation.dogadjaj_list.components.DogadjajMainItemList
import com.example.cs330pz.presentation.mesto_list.MestoListScreen
import com.example.cs330pz.presentation.mesto_list.components.MestoListItem
import com.example.cs330pz.presentation.nav_bar.NavBar
import com.example.cs330pz.presentation.nav_bar.NavBarViewModel
import com.example.cs330pz.presentation.problem_add.ProblemiScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogadjajMainScreen (
    navController: NavController,
    viewModel: DogadjajiViewModel = hiltViewModel(),
    navViewModel: NavBarViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        Column(modifier = Modifier.background(color = Color.Cyan)) {
            NavBar(navController = navController)
        }
        //NavBar(navController = navController)

        Scaffold(
        ) {
            //CocktailMainListItem(navController, viewModel)
            if (navViewModel.state.value.isMainPage) {
                DogadjajMainItemList(navController = navController)
            } else if (!navViewModel.state.value.isMainPage && !navViewModel.state.value.localDatabase) {
                MestoListScreen(navController = navController)
            }
            else{
                ProblemiScreen(navController = navController)
            }
        }

    }
}