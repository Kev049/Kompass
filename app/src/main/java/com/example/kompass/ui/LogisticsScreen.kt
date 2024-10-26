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
fun LogisticsScreen(
    innerPadding: PaddingValues,
    onItemClicked: (SecondaryButtonItem) -> Unit,
    onNavigate: (KompassScreen) -> Unit
) {
    val cardWidth = 150
    val cardHeight = 300
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
                SecondaryButton(SecondaryButtonItem.Availability, onNavigate = onNavigate, onItemClicked = onItemClicked, cardWidth = cardWidth, cardHeight = cardHeight)
                SecondaryButton(SecondaryButtonItem.Location, onNavigate = onNavigate, onItemClicked = onItemClicked, cardWidth = cardWidth, cardHeight = cardHeight)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SecondaryButton(SecondaryButtonItem.Delivery, onNavigate = onNavigate, onItemClicked = onItemClicked, cardWidth = cardWidth, cardHeight = cardWidth)
                SecondaryButton(SecondaryButtonItem.History, onNavigate = onNavigate, onItemClicked = onItemClicked, cardWidth = cardWidth, cardHeight = cardWidth)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogisticsScreen() {
    val defaultPadding = PaddingValues(0.dp)
    LogisticsScreen(innerPadding = defaultPadding, onItemClicked = {}, onNavigate = {})
}
