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
import com.example.kompass.types.ProductItem
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.IkeaDarkBlue

@Composable
fun SearchItemCard(
    searchItem: ProductItem,
    onCardClick: (ProductItem) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 6.dp) // External padding applied to the Box
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(IkeaDarkBlue, shape = RoundedCornerShape(12.dp))
                .clickable { onCardClick(searchItem) }
                .padding(horizontal = 16.dp), // Internal padding for Row content
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = searchItem.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(end = 16.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
            ) {
                Text(
                    text = searchItem.name,
                    color = Color.White,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = searchItem.category.toDisplayName(),
                    color = Color.White,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start
                )
            }
        }
    }

}
