package com.example.kompass.ui.cards

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.example.kompass.types.SubCategory

@Composable
fun SubCategoryCard(subcategory: SubCategory, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .size(150.dp, 200.dp), // Fixed size for the card
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Image
            Image(
                painter = painterResource(id = subcategory.imageResId),
                contentDescription = subcategory.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                contentScale = ContentScale.Crop
            )
            // Text
//            Text(
//                text = subCategoryItem.description,
//                color = Color.White,
//                fontSize = 18.sp,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .height(60.dp)
//                    .width(140.dp)
//                    .wrapContentHeight(align = Alignment.CenterVertically),
//            )
        }
    }
}