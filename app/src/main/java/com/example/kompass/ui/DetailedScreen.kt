package com.example.kompass.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun DetailedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp,10.dp,1.dp,1.dp),
        verticalArrangement = Arrangement.Top
    ) {
        InfoBar(Color.Black)
        NavHeader()
        ContentBody(Color.Black)
    }
}

@Composable
fun ContentBody(
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
            text = "Mått",
            color = textColor,
            fontSize = 25.sp,
            fontWeight = FontWeight(700),
            fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically),
        )
        Text(
            text = "Längd: PROBLEM??\nBredd: PROBLEM??\nHöjd: PROBLEM??\nVikt: PROBLEM??\n",
            color = textColor,
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            fontFamily = FontFamily(Font(R.font.noto_sans_light)),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically),
        )
    }
}

@Composable
private fun NavHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(IkeaDarkBlue, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.t),
                contentDescription = "placeholder",
                modifier = Modifier
                    .size(150.dp)
                    .padding(5.dp),
                contentScale = ContentScale.Fit
            )
        }
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .padding(vertical = 20.dp)
        ) {
            NavCollection()
        }
    }
}

@Composable
private fun InfoBar(
    textColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(75.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "PROBLEM??",
                color = textColor,
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
            Text(
                text = "1337.420.69",
                color = textColor,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.noto_sans_light)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .height(30.dp)
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
                text = "Sussy baka",
                color = textColor,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
            Text(
                text = "en njure:-",
                color = textColor,
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.noto_sans_light)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .height(30.dp)
                    .wrapContentWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }
    }
}

@Composable
fun NavCollection() {
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
            SmallNavButton(R.drawable.menu_basic_spec)
            SmallNavButton(R.drawable.menu_basic_contents)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallNavButton(R.drawable.menu_basic_dimensions)
            SmallNavButton(R.drawable.menu_basic_materials)
        }
    }
}

@Composable
fun SmallNavButton(
    img: Int
) {
    Box(
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(img),
            contentDescription = "placeholder",
            modifier = Modifier.size(90.dp)
                .padding(5.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailedPreview() {
    DetailedScreen()
}