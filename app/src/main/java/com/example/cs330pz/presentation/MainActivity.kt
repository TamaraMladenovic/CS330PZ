package com.example.cs330pz.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cs330pz.presentation.dogadjaj_detail.components.DogadjajiDetailScreen
import com.example.cs330pz.presentation.dogadjaj_list.DogadjajMainScreen
import com.example.cs330pz.presentation.dogadjaj_list.components.DogadjajMainItemList
import com.example.cs330pz.presentation.mesto_list.MestoListScreen
import com.example.cs330pz.presentation.problem_add.ProblemiScreen
import com.example.cs330pz.presentation.theme.CS330PZTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CS330PZTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.DogadjajiMainScreen.route){
                        composable(route = Screen.DogadjajiMainScreen.route){
                            DogadjajMainScreen(navController = navController)
                        }
                        composable(route = Screen.ProblemScreen.route){
                            ProblemiScreen(navController = navController)
                        }
                        composable(route = Screen.MestoListScreen.route){
                            MestoListScreen(navController = navController)
                        }
                        composable(route = Screen.DogadjajiListScreen.route){
                            DogadjajMainItemList(navController = navController)
                        }
                        composable(
                            route = Screen.DogadjajiDetailScreen.route + "/{dogadjajId}"
                        ) {
                            DogadjajiDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
