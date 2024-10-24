package com.example.kompass.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.types.SearchItemInfo
import com.example.kompass.ui.theme.IkeaBlue

@Composable
fun SearchItemCard(
    searchItem: SearchItemInfo,
    modifier: Modifier = Modifier,
    onCardClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(12.dp))
            .clickable { onCardClick(searchItem.name) }
            .padding(8.dp), // Add some padding to the Row
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = searchItem.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(end = 16.dp) // Add some space between the image and text
        )

        Column(
            modifier = Modifier
                .weight(1f) // Allow the text to take the remaining space
                .wrapContentHeight()
        ) {
            Text(
                text = searchItem.name,
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Start // Align text to the start
            )
            Text(
                text = searchItem.category,
                color = Color.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Start // Align text to the start
            )
        }
    }
}
