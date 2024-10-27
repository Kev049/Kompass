package com.example.kompass.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.KompassScreen
import com.example.kompass.R
import com.example.kompass.types.ContentsCard
import com.example.kompass.types.DimensionInfo
import com.example.kompass.ui.cards.ContentsCardItem
import com.example.kompass.ui.theme.BgBlack
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.IkeaDarkBlue
import com.example.kompass.ui.theme.IkeaYellow

@Composable
fun DetailedMaterialsScreen(
    fontColor: Color = Color.White,
    onNavigate: (KompassScreen) -> Unit,
    innerPadding: PaddingValues,
    productImage: Int,
    productName: String,
    productNumber: String,
    productCategory: String,
    productPrice: Int,
    materialsDescription: String
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BgBlack)
            .padding(innerPadding),
    ) {
        item {
            InfoBar(fontColor, productName, productNumber, productCategory, productPrice)
            NavHeader(productImage, navCollection = { NavCollection5(onNavigate) })
            ContentBody(fontColor, materialsDescription)
            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}

@Composable
private fun ContentBody(
    textColor: Color,
    materialsDescription: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 20.dp, 20.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Materials",
            color = textColor,
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically),
        )
        MaterialsList(materialsDescription)
    }
}

@Composable
private fun MaterialsList(
    materialsDescription: String
) {
    // Split the description by sections based on double newline
    val sections = materialsDescription.split("\n\n").map { section ->
        val parts = section.split(":\n", limit = 2)
        val title = parts.getOrNull(0) ?: ""
        val content = parts.getOrNull(1) ?: ""
        title to content
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 10.dp, 0.dp, 0.dp),
    ) {
        sections.forEach { (title, content) ->
            if (title.isNotBlank() && content.isNotBlank()) {
                SectionItem(title = title, content = content)
            }
        }
    }
}

@Composable
private fun SectionItem(
    title: String,
    content: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(IkeaDarkBlue, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
            .padding(bottom = 8.dp) // Space between sections
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically),
        )
        Spacer(modifier = Modifier.height(4.dp)) // Space between title and content
        Text(
            text = content,
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.noto_sans)),
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically),
        )
    }
    Spacer(modifier = Modifier.height(14.dp)) // Space between different sections
}

@Composable
fun NavCollection5(onNavigate: (KompassScreen) -> Unit,) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallNavButton(R.drawable.menu_basic_dimensions, onNavigate = onNavigate, detailedScreen = KompassScreen.DetailedDimensions)
            SmallNavButton(R.drawable.menu_basic_contents, onNavigate = onNavigate, detailedScreen = KompassScreen.DetailedContents)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallNavButton(R.drawable.menu_basic_spec, onNavigate = onNavigate, detailedScreen = KompassScreen.DetailedProductSpecifics)
            SmallNavButton(R.drawable.menu_basic_materials, IkeaYellow, ColorFilter.tint(IkeaBlue), onNavigate, KompassScreen.DetailedMaterials)
        }
    }
}


