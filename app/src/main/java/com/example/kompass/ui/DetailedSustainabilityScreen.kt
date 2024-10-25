package com.example.kompass.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
            .background(BgBlack)
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
        EmissionEntry(
            "Carbon Emissions",
            12,
            textColor
        )
        MaterialsEntry(
            "Origin of Materials",
            "Wood",
            "Sweden",
            textColor
        )
        InfoEntry(
            "Recyclability",
            "The product is 100% recyclable",
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
        fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(0.dp,10.dp,0.dp,0.dp),
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .background(IkeaDarkBlue, shape = RoundedCornerShape(10.dp)),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = description,
            color = textColor,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(10.dp,0.dp,0.dp,0.dp),
        )
    }
}

@Composable
private fun MaterialsEntry(
    title: String,
    materialText: String,
    originText: String,
    textColor: Color
){
    Text(
        text = title,
        color = textColor,
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(0.dp,10.dp,0.dp,0.dp),
    )
    Column {
        MaterialListItem(materialText, originText, textColor, true)
        MaterialListItem("Steel", originText, textColor, false)
        MaterialListItem("Plastic", "Norway", textColor, true)
    }
}

@Composable
fun MaterialListItem(
    materialText: String,
    originText: String,
    textColor: Color,
    hasBackground: Boolean
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .then(
                if (hasBackground) {
                    Modifier.background(IkeaDarkBlue, shape = RoundedCornerShape(10.dp))
                } else {
                    Modifier
                }
            ),
        verticalArrangement = Arrangement.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = materialText,
                    color = textColor,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = originText,
                    color = textColor,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                )
            }
        }
    }
}

@Composable
private fun EmissionEntry(
    title: String,
    emissionAmount: Int,
    textColor: Color
){
    Text(
        text = title,
        color = textColor,
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(0.dp,10.dp,0.dp,0.dp),
    )
    Column {
        EmissionListItem(emissionAmount, textColor)
    }
}

@Composable
fun EmissionListItem(
    emissionAmount: Int,
    textColor: Color,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .background(IkeaDarkBlue, shape = RoundedCornerShape(10.dp)),
        verticalArrangement = Arrangement.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "CO₂ Emissions",
                    color = textColor,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "$emissionAmount tonnes" ,
                    color = textColor,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                )
            }
        }
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
        Color.White,
        R.drawable.t,
        "Placeholder",
        "100.130.35",
        "Placeholder",
        1000
    )
}