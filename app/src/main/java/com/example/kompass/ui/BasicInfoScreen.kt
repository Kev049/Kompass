package com.example.kompass.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.CategoryItem
import com.example.kompass.NavBarButtons
import com.example.kompass.NavBarItem
import com.example.kompass.NavButtons
import com.example.kompass.R
import com.example.kompass.topBorder
import com.example.kompass.ui.theme.KompassTheme
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.BgBlack

@Composable
fun BasicInfoScreen(
) {
        Scaffold(
            containerColor = BgBlack,
            bottomBar = {
                BottomAppBar(
                    containerColor = Color.Black,
                    contentColor = Color.Yellow,
                    modifier = Modifier
                        .height(72.dp)
                        .topBorder(Color.White, 0.5f)
                ) {
                    NavBarButtons()
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding), // Avoid overlap with BottomAppBar
                contentAlignment = Alignment.Center
            ) {
                val categories = listOf(
                    CategoryItem.Dimensions, CategoryItem.Contents,
                    CategoryItem.Specific, CategoryItem.Materials
                )
                NavButtons(categories)
            }
        }
}


@Composable
fun CategoryBtn2(
    categoryItem: CategoryItem, )
{
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(320.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(8.dp))
            .clickable { println("${categoryItem.description} button Clicked") },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center-align items horizontally
            verticalArrangement = Arrangement.Center // Center-align items vertically
        ) {
                Image(

                    painter = painterResource(id = categoryItem.icon),
                    contentDescription = "${categoryItem.description} icon",
                    modifier = Modifier.size(110.dp)
                        .padding(bottom = 8.dp),
                    contentScale = ContentScale.Fit
                )
            Text(
                text = categoryItem.description,
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                        .height(60.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InfoScreenPreview(
) {
    KompassTheme {
        BasicInfoScreen(
        )
    }
}

