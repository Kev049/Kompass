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
import com.example.kompass.SecondaryButtonItem

@Composable
fun BasicInfoScreen(
    innerPadding: PaddingValues,
    onItemClicked: (SecondaryButtonItem) -> Unit,
    onNavigate: (KompassScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding), // Avoid overlap with BottomAppBar
        contentAlignment = Alignment.Center
    ){
        val cardWidth = 150
        val cardHeight = 300
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
                SecondaryButton(SecondaryButtonItem.Dimensions, onNavigate = onNavigate, onItemClicked = onItemClicked, cardWidth = cardWidth, cardHeight = cardHeight, toScreen = KompassScreen.Category)
                SecondaryButton(SecondaryButtonItem.Contents, onNavigate = onNavigate, onItemClicked = onItemClicked, cardWidth = cardWidth, cardHeight = cardHeight, toScreen = KompassScreen.Category)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SecondaryButton(SecondaryButtonItem.Specific, onNavigate = onNavigate, onItemClicked = onItemClicked, cardWidth = cardWidth, cardHeight = cardHeight, toScreen = KompassScreen.Category)
                SecondaryButton(SecondaryButtonItem.MaterialsBasic, onNavigate = onNavigate, onItemClicked = onItemClicked, cardWidth = cardWidth, cardHeight = cardHeight, toScreen = KompassScreen.Category)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBasicInfoScreen() {
    val defaultPadding = PaddingValues(0.dp)
    BasicInfoScreen(innerPadding = defaultPadding,
    onNavigate = {},
    onItemClicked = { item ->
        //println("Clicked on: ${item.description}")
        }
    )
}
