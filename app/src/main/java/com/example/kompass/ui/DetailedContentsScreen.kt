package com.example.kompass.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import com.example.kompass.R
import com.example.kompass.types.ContentsCard
import com.example.kompass.types.DimensionInfo
import com.example.kompass.ui.cards.ContentsCardItem
import com.example.kompass.ui.theme.BgBlack
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.IkeaDarkBlue
import com.example.kompass.ui.theme.IkeaYellow

@Composable
fun DetailedContentsScreen(
    fontColor: Color = Color.White,
    innerPadding: PaddingValues,
    productImage: Int,
    productName: String,
    productNumber: String,
    productCategory: String,
    productPrice: Int,
    contentCards: List<ContentsCard>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BgBlack)
            .padding(innerPadding),
        verticalArrangement = Arrangement.Top
    ) {
        item {
            InfoBar(fontColor, productName, productNumber, productCategory, productPrice)
            NavHeader(productImage, navCollection = { NavCollection4() })
            ContentBody(fontColor, contentCards)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun ContentBody(
    textColor: Color,
    contentCards: List<ContentsCard>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 20.dp, 20.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Contents",
            color = textColor,
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically),
        )
        ContentsList(contentCards)
    }
}

@Composable
private fun ContentsList(contentCards: List<ContentsCard>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 10.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        if (contentCards.isEmpty()) {
            Text(
                text = "No extra items included",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                textAlign = TextAlign.Center
            )
        } else {
            contentCards.forEach { contentCard ->
                ContentsCardItem(contentCard)
            }
        }
    }
}

@Composable
fun NavCollection4() {
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
            SmallNavButton(R.drawable.menu_basic_dimensions)
            SmallNavButton(R.drawable.menu_basic_contents, IkeaYellow, ColorFilter.tint(IkeaBlue))
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

@Preview(showBackground = true)
@Composable
fun PreviewDetailedContentsScreen() {
    val defaultPadding = PaddingValues(0.dp)
        val contentCards = listOf(ContentsCard("1 x Continental Bed", "140x200 cm", "SÄBOVIK", R.drawable.sabovik), ContentsCard("1 x Mattress", "140x200 cm", "SÄBOVIK", R.drawable.sabovik))
    DetailedContentsScreen(Color.White, innerPadding = defaultPadding, R.drawable.slattum, "Slattum", "405.712.48", "Bed Frame", 1495, contentCards)
}

