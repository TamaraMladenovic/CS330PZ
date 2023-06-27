package com.example.cs330pz.presentation

sealed class Screen(val route: String){
    object MestoListScreen: Screen("mesto_list_screen")
    object DogadjajiMainScreen: Screen("dogadjaj_main_screen")
    object DogadjajiListScreen: Screen("dogadjaji_list_screen")
    object DogadjajiDetailScreen: Screen("dogadjaji_detail_screen")

    object ProblemScreen: Screen("problem_add_screen")
}
