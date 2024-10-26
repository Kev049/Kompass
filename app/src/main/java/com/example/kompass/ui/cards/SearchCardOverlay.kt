package com.example.kompass.ui.cards

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.CategoryItem
import com.example.kompass.KompassScreen
import com.example.kompass.R
import com.example.kompass.SubButtonItem
import com.example.kompass.types.ProductItem
import com.example.kompass.ui.SubButton
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.IkeaDarkBlue

@Composable
fun SearchCardOverlay(
    onNavigate: (KompassScreen) -> Unit,
    onItemClicked: (SubButtonItem) -> Unit,
    onBackClick: () -> Unit,
    productItem: ProductItem
) {
    var selectedCategory by remember { mutableStateOf<CategoryItem?>(null) }
    val subButtons = mapOf(
        CategoryItem.Basic to listOf(
            SubButtonItem.Specific,
            SubButtonItem.Contents,
            SubButtonItem.Dimensions,
            SubButtonItem.Materials
        ),
        CategoryItem.Logistics to listOf(
            SubButtonItem.Availability,
            SubButtonItem.Location,
            SubButtonItem.Delivery,
            SubButtonItem.History
        ),
        CategoryItem.Sustainability to listOf(
            SubButtonItem.Sustainability,
            SubButtonItem.Description,
            SubButtonItem.Materials
        ),
        CategoryItem.Documents to listOf(
            SubButtonItem.Manual,
            SubButtonItem.Installation,
            SubButtonItem.Safety,
            SubButtonItem.Policy
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 50.dp, 10.dp, 10.dp)
    ) {
        Box(
            modifier = Modifier
                .background(IkeaDarkBlue, shape = RoundedCornerShape(12.dp))
                .matchParentSize(),
            contentAlignment = Alignment.Center
        ) {
            Column{
                CardHeader(onBackClick, productItem.name)
                if (selectedCategory == null) {
                    PlaceSearchMainButtons(
                        onMainButtonClick = { category ->
                            selectedCategory = category
                        }
                    )
                } else {
                    PlaceSubButtons(
                        subButtons = subButtons[selectedCategory] ?: emptyList(),
                        onItemClicked = onItemClicked,
                        onNavigate = onNavigate
                    )
                }
            }
        }
    }
}

@Composable
fun CardHeader(
    onBackClick: () -> Unit,
    productName: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 15.dp, vertical = 5.dp),
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
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .clickable { onBackClick() }, // Close overlay when clicked
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "BACK",
                color = Color.White,
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

@Composable
fun PlaceSearchMainButtons(
    onMainButtonClick: (CategoryItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SearchMainButton(CategoryItem.Basic, onClick = { onMainButtonClick(CategoryItem.Basic) })
            SearchMainButton(CategoryItem.Logistics, onClick = { onMainButtonClick(CategoryItem.Logistics) })
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SearchMainButton(CategoryItem.Sustainability, onClick = { onMainButtonClick(CategoryItem.Sustainability) })
            SearchMainButton(CategoryItem.Documents, onClick = { onMainButtonClick(CategoryItem.Documents) })
        }
    }
}

@Composable
private fun SearchMainButton(
    categoryItem: CategoryItem,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(140.dp)
            .height(225.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(12.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center-align items horizontally
            verticalArrangement = Arrangement.Center // Center-align items vertically
        ) {
            Image(
                painter = painterResource(id = categoryItem.icon),
                contentDescription = "${categoryItem.description} icon",
                modifier = Modifier
                    .size(90.dp)
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
                    .width(140.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }
    }
}

@Composable
private fun PlaceSubButtons(
    subButtons: List<SubButtonItem>,
    onItemClicked: (SubButtonItem) -> Unit,
    onNavigate: (KompassScreen) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        subButtons.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowItems.forEach { subButton ->
                    SubButton(subButton, onItemClicked = onItemClicked, onNavigate = onNavigate, 140, 225)
                }
            }
        }
    }
}
