package com.example.kompass.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.KompassScreen
import com.example.kompass.R
import com.example.kompass.types.DimensionInfo
import com.example.kompass.ui.theme.BgBlack
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.IkeaDarkBlue
import com.example.kompass.ui.theme.IkeaYellow

@Composable
fun DetailedDimensionsScreen(
    fontColor: Color = Color.White,
    onNavigate: (KompassScreen) -> Unit,
    innerPadding: PaddingValues,
    productImage: Int,
    productName: String,
    productNumber: String,
    productCategory: String,
    productPrice: Int,
    dimensionInfo: DimensionInfo
) {
    Column(
        modifier = Modifier
            .background(BgBlack)
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        InfoBar(fontColor, productName, productNumber, productCategory, productPrice)
        NavHeader(productImage, navCollection = { NavCollection(onNavigate) })
        ContentBody(fontColor, dimensionInfo.length, dimensionInfo.width, dimensionInfo.height, dimensionInfo.mattressLength, dimensionInfo.mattressWidth)
    }
}

@Composable
private fun ContentBody(
    textColor: Color,
    length: Int,
    width: Int,
    height: Int,
    mattressLength: Int,
    mattressWidth: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 5.dp, 20.dp, 0.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(
            text = "Measurements",
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
            DimensionListItem("Length", length, textColor, true)
            DimensionListItem("Width", width, textColor, false)
            DimensionListItem("Height", height, textColor, true)
            DimensionListItem("Mattress Length", mattressLength, textColor, false)
            DimensionListItem("Mattress Width", mattressWidth, textColor, true)
        }
    }
}

@Composable
fun DimensionListItem(
    dimension: String,
    dimensionValue: Int,
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
                    text = dimension,
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
                    text = "$dimensionValue cm",
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
fun NavHeader(
    productImage: Int,
    navCollection: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .background(IkeaDarkBlue, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .padding(vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(productImage),
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(150.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Fit
            )
        }
        Column(
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            navCollection()
        }
    }
}

@Composable
fun InfoBar(
    textColor: Color,
    productName: String,
    productNumber: String,
    productCategory: String,
    productPrice: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp, 20.dp, 0.dp)
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
                text = productName,
                color = textColor,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
            Text(
                text = productNumber,
                color = textColor,
                fontSize = 18.sp,
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
                text = productCategory,
                color = textColor,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
            Text(
                text = "$productPrice:-",
                color = textColor,
                fontSize = 18.sp,
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
fun NavCollection(onNavigate: (KompassScreen) -> Unit) {
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
            SmallNavButton(R.drawable.menu_basic_dimensions, IkeaYellow, ColorFilter.tint(IkeaBlue), onNavigate = onNavigate, detailedScreen = KompassScreen.DetailedDimensions)
            SmallNavButton(R.drawable.menu_basic_contents, onNavigate = onNavigate, detailedScreen = KompassScreen.DetailedContents)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallNavButton(R.drawable.menu_basic_spec, onNavigate = onNavigate, detailedScreen = KompassScreen.DetailedProductSpecifics)
            SmallNavButton(R.drawable.menu_basic_materials, onNavigate = onNavigate, detailedScreen = KompassScreen.DetailedMaterials)
        }
    }
}

@Composable
fun SmallNavButton(
    img: Int,
    color: Color = IkeaBlue,
    iconColor: ColorFilter = ColorFilter.tint(Color.White),
    onNavigate: (KompassScreen) -> Unit,
    detailedScreen: KompassScreen
) {
    Box(
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .background(color, shape = RoundedCornerShape(10.dp))
            .clickable { onNavigate(detailedScreen) },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(img),
            contentDescription = "placeholder",
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Fit,
            colorFilter = iconColor
        )
    }
}

/*
@Composable
fun NavCollection() {
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
            NavButton(R.drawable.vector_left) {}
            Image(
                painter = painterResource(id = R.drawable.menu_main_info),
                contentDescription = "navigate",
                modifier = Modifier
                    .size(32.dp)
            )
            NavButton(R.drawable.vector_right) {}
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallNavButton(R.drawable.menu_basic_dimensions, IkeaYellow, ColorFilter.tint(IkeaBlue))
            SmallNavButton(R.drawable.menu_basic_contents)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SmallNavButton(R.drawable.menu_basic_spec)
            SmallNavButton(R.drawable.menu_basic_materials)
        }
    }
}
 */


