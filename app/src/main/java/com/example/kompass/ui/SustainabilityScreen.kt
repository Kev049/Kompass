package com.example.kompass.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kompass.KompassScreen
import com.example.kompass.SubButtonItem

@Composable
fun SustainabilityScreen(
    innerPadding: PaddingValues,
    onItemClicked: (SubButtonItem) -> Unit,
    onNavigate: (KompassScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding), // Avoid overlap with BottomAppBar
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SubButton(SubButtonItem.Sustainability, onNavigate = onNavigate, onItemClicked = onItemClicked)
                SubButton(SubButtonItem.Description, onNavigate = onNavigate, onItemClicked = onItemClicked)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SubButton(SubButtonItem.Materials, onNavigate = onNavigate, onItemClicked = onItemClicked)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewSustainabilityScreen() {
//    val defaultPadding = PaddingValues(0.dp)
//    SustainabilityScreen(innerPadding = defaultPadding) {}
//}
