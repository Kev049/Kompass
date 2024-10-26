package com.example.kompass.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.KompassScreen
import com.example.kompass.SecondaryButtonItem
import com.example.kompass.ui.theme.IkeaBlue

@Composable
fun SecondaryButton(
    secondaryButtonItem: SecondaryButtonItem,
    onItemClicked: (SecondaryButtonItem) -> Unit,
    onNavigate: (KompassScreen) -> Unit,
    cardWidth: Int,
    cardHeight: Int,
    toScreen: KompassScreen
) {
    Box(
        modifier = Modifier
            .width(cardWidth.dp)
            .height(cardHeight.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(12.dp))
            //TODO: Navigate to product screen and pass right category
            .clickable { onItemClicked(secondaryButtonItem)
                onNavigate(toScreen) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center-align items horizontally
            verticalArrangement = Arrangement.Center // Center-align items vertically
        ) {
            Image(
                painter = painterResource(id = secondaryButtonItem.icon),
                contentDescription = "${secondaryButtonItem.description} icon",
                modifier = Modifier.size(90.dp)
                    .padding(bottom = 8.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = secondaryButtonItem.description,
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .height(60.dp)
                    .width(140.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }
    }
}