package com.example.kompass.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.R
import com.example.kompass.ui.theme.BgBlack
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.IkeaDarkBlue
import com.example.kompass.ui.theme.IkeaYellow

@Composable
fun DetailedLogisticsScreen(
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
        NavHeader(productImage, navCollection = { NavCollection2() })
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
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Stores",
            color = textColor,
            fontSize = 25.sp,
            fontWeight = FontWeight(700),
            fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically),
        )
        StoreAvaliabilityColumn()
    }
}



@Composable
private fun StoreAvaliabilityColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),

    ) {
        StoreBox(
            "IKEA Gothenburg Bäckebol",
            "Transportgatan 23, Hisings Backa",
            "Store - 19 available",
            "Click & collect - Available"
        )
        StoreBox(
            "IKEA Gothenburg Kållered",
            "Ekenleden 4, Kållered",
            "Store - 14 available",
            "Click & collect - Available"
        )
        StoreBox(
            "IKEA Borlänge",
            "Norra Backagatan 1, Borlänge",
            "Store - 23 available",
            "Click & collect - Unavailable"
        )
    }
}

@Composable
private fun StoreBox(
    storeName: String,
    storeLocation: String,
    storeStatus: String,
    onlineStatus: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(IkeaDarkBlue, shape = RoundedCornerShape(10.dp))
    ) {
        Text(
            text = storeName,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight(700),
            fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(7.dp),
        )
        Text(
            text = storeLocation,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            fontFamily = FontFamily(Font(R.font.noto_sans_light)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(horizontal = 7.dp, vertical = 2.dp),
        )
        Text(
            text = storeStatus,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            fontFamily = FontFamily(Font(R.font.noto_sans_light)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(horizontal = 7.dp, vertical = 2.dp),
        )
        Text(
            text = onlineStatus,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            fontFamily = FontFamily(Font(R.font.noto_sans_light)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(horizontal = 7.dp, vertical = 2.dp),
        )
    }
}

@Composable
fun NavCollection2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgBlack, shape = RoundedCornerShape(15.dp)),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavButton(R.drawable.vector_left, {})
            Image(
                painter = painterResource(id = R.drawable.menu_main_logistics),
                contentDescription = "navigate",
                modifier = Modifier.size(32.dp)
            )
            NavButton(R.drawable.vector_right, {})
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallNavButton(R.drawable.menu_logistics_availability, IkeaYellow, ColorFilter.tint(IkeaBlue))
            SmallNavButton(R.drawable.menu_logistics_location)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallNavButton(R.drawable.menu_logistics_delivery)
            SmallNavButton(R.drawable.menu_logistics_history)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailedLogisticsPreview() {
    DetailedLogisticsScreen(
        Color.Black,
        R.drawable.t,
        "Problem??",
        "1337.420.69",
        "Sussy baka",
        1337
    )
}