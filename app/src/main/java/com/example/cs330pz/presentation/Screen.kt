package com.example.cs330pz.presentation

sealed class Screen(val route: String){
    object MestoListScreen: Screen("mesto_list_screen")
    object DogadjajiScreen: Screen("dogadjaji_list_screen")
    object DogadjajiDetailScreen: Screen("dogadjaji_detail_screen")
}
