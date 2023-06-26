package com.example.cs330pz.presentation.dogadjaj_detail.components

import android.annotation.SuppressLint
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cs330pz.domain.model.Dogadjaji
import com.example.cs330pz.presentation.dogadjaj_detail.DogadjajDetailViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun DogadjajiDetailScreen(
    viewModel: DogadjajDetailViewModel = hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier.padding(top = 20.dp),
){
    val state = viewModel.state.value
    val coroutineScope = rememberCoroutineScope()

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ){
        Box(modifier = Modifier.fillMaxWidth()){
            state.dogadjaj?.let { dogadjaj ->
                IconButton(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .scale(1.5f),
                    onClick = {
                        navController.popBackStack()
                    }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                Text(
                    text = "${dogadjaj.naziv}",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${dogadjaj.vreme}, ${dogadjaj.lokacija}",
                    style = MaterialTheme.typography.labelSmall,
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${dogadjaj.opis}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.TopStart)
                )
            }
        }
    }
}