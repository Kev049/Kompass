package com.example.kompass.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.R
import com.example.kompass.ui.theme.IkeaDarkBlue
import com.example.kompass.ui.theme.IkeaYellow

@Composable
fun DetailedLogisticsScreen(
    fontColor: Color = Color.White
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp,10.dp,1.dp,1.dp),
        verticalArrangement = Arrangement.Top
    ) {
        InfoBar(fontColor)
        NavHeader(R.drawable.t, navCollection = { NavCollection2() })
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
            "Store - 19 avaliable",
            "Click & collect - Avaliable"
        )
        StoreBox(
            "IKEA Gothenburg Kållered",
            "Ekenleden 4, Kållered",
            "Store - 14 avaliable",
            "Click & collect - Avaliable"
        )
        StoreBox(
            "IKEA Borlänge",
            "Norra Backagatan 1, Borlänge",
            "Store - 23 avaliable",
            "Click & collect - Avaliable"
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
            .background(IkeaBlue, shape = RoundedCornerShape(10.dp))
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
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
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
    DetailedLogisticsScreen(Color.Black)
}