package com.example.kompass.ui.cards

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import com.example.kompass.types.Category
import com.example.kompass.KompassScreen
import com.example.kompass.ui.theme.IkeaBlue

@Composable
fun CategoryCard(
    category: Category,
    modifier: Modifier = Modifier,
    screenWidth: Int,
    screenHeight: Int,
    onNavigate: (KompassScreen) -> Unit,
    screen: KompassScreen
) {
    val paddingBetweenCards = 8
    val cardWidth = (screenWidth/2 - 10)
    val cardHeight = (screenHeight*0.14)
    Box(
        modifier = Modifier
            .padding()
            .width(cardWidth.dp)
            .height(cardHeight.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(12.dp))
            .clickable { onNavigate(screen) },

                //.clickable {onNavigate(KompassScreen.SubCategory)},
            //.clickable {onNavigate(KompassScreen.ProductList)}, //TODO: Byt ut .Home mot något som är rätt
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize(), // Fill the card size
            verticalAlignment = Alignment.CenterVertically // Center items vertically
        )
        {
            // Image
            Image(
                painter = painterResource(id = category.imageResId),
                contentDescription = category.description,
                modifier = Modifier
                    //.fillMaxWidth()
                    .padding(2.dp)
                    .width((cardWidth*0.4).dp) //frågan är om bilden borde vara en fixed storlek
                    .height((cardHeight*0.8).dp),
                    //.clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                contentScale = ContentScale.Fit
            )
            // Text
            Text(
                text = category.name, //denna är skriven ganska annorlunda från tutorial
                //text = primaryButtonItem.description,
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(2.dp)
                    .width((cardWidth - 10).dp)
                    .height((cardHeight).dp)
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CategoryCardPreview(){
//    CategoryCard(Category(R.drawable.navbar_home, "TestName","Whaddup?"), modifier = Modifier.padding(0.dp),320, 668)
//}