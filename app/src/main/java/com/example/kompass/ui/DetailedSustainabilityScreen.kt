package com.example.kompass.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import com.example.kompass.R
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.IkeaYellow

@Composable
fun DetailedSustainabilityScreen(
    fontColor: Color = Color.White,
    productImage: Int,
    productName: String,
    productNumber: String,
    productCategory: String,
    productPrice: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp,10.dp,1.dp,1.dp),
        verticalArrangement = Arrangement.Top
    ) {
        InfoBar(fontColor, productName, productNumber, productCategory, productPrice)
        NavHeader(productImage, navCollection = { NavCollection3() })
        ContentBody(fontColor)
    }
}

@Composable
private fun ContentBody(
    textColor: Color
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        InfoEntry(
            "Co2 Emissions",
            "Lorem Ipsum Yada-Yada",
            textColor
        )
        InfoEntry(
            "Materials and origin",
            "Wood, Birch - Sweden\nSteel - Germany",
            textColor
        )
    }
}

@Composable
private fun InfoEntry(
    title: String,
    description: String,
    textColor: Color
) {
    Text(
        text = title,
        color = textColor,
        fontSize = 25.sp,
        fontWeight = FontWeight(700),
        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(0.dp,10.dp,0.dp,0.dp),
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(10.dp))
    ) {
        Text(
            text = description,
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight(700),
            fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(7.dp),
        )
    }
}

@Composable
fun NavCollection3() {
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
            SmallNavButton(R.drawable.menu_main_sustainability, IkeaYellow, ColorFilter.tint(IkeaBlue))
            SmallNavButton(R.drawable.menu_sustainability_description)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallNavButton(R.drawable.menu_basic_materials)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailedSustainabilityPreview() {
    DetailedSustainabilityScreen(
        Color.Black,
        R.drawable.t,
        "Problem??",
        "1337.420.69",
        "Sussy baka",
        1337
    )
}