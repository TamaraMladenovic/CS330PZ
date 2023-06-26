package com.example.cs330pz.presentation

sealed class Screen(val route: String){
    object MestoListScreen: Screen("mesto_list_screen")
}
