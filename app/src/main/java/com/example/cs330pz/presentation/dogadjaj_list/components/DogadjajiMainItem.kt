package com.example.cs330pz.presentation.dogadjaj_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cs330pz.domain.model.Dogadjaji

@Composable
fun DogadjajiMainItem(
    dogadjaj: Dogadjaji,
    modifier: Modifier = Modifier,
    onItemClick: (Dogadjaji) -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 18.dp
        ),
        modifier = modifier
            .clickable { onItemClick(dogadjaj) }
            .fillMaxSize()
            .width(280.dp)
            .background(color = MaterialTheme.colorScheme.onSurfaceVariant)
            .clickable {
                onItemClick(dogadjaj)
            }, shape = MaterialTheme.shapes.large
    ){
        Column(
            modifier = Modifier
                .padding(2.dp)
                .align(Alignment.CenterHorizontally)
        ){
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "${dogadjaj.naziv}",
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "Vreme i mesto: ${dogadjaj.vreme}, ${dogadjaj.lokacija}",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "${dogadjaj.opis}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )
        }

    }
}