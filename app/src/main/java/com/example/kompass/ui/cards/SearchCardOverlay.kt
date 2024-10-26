package com.example.kompass.ui.cards

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
import androidx.compose.runtime.LaunchedEffect
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
import com.example.kompass.KompassScreen
import com.example.kompass.PrimaryButtonItem
import com.example.kompass.R
import com.example.kompass.SecondaryButtonItem
import com.example.kompass.types.ProductItem
import com.example.kompass.ui.SecondaryButton
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.IkeaDarkBlue

@Composable
fun SearchCardOverlay(
    onNavigate: (KompassScreen) -> Unit,
    onSecondaryItemClicked: (SecondaryButtonItem) -> Unit,
    onBackClick: () -> Unit,
    productItem: ProductItem,
    inSubCategory: Boolean,
    setInSubCategory: (Boolean) -> Unit
) {
    var selectedCategory by remember { mutableStateOf<PrimaryButtonItem?>(null) }

    LaunchedEffect(inSubCategory) {
        if (!inSubCategory) {
            selectedCategory = null
        }
    }

    val secondaryButtons = mapOf(
        PrimaryButtonItem.Basic to listOf(
            SecondaryButtonItem.Specific,
            SecondaryButtonItem.Contents,
            SecondaryButtonItem.Dimensions,
            SecondaryButtonItem.MaterialsBasic
        ),
        PrimaryButtonItem.Logistics to listOf(
            SecondaryButtonItem.Availability,
            SecondaryButtonItem.Location,
            SecondaryButtonItem.Delivery,
            SecondaryButtonItem.History
        ),
        PrimaryButtonItem.Sustainability to listOf(
            SecondaryButtonItem.Sustainability,
            SecondaryButtonItem.Description,
            SecondaryButtonItem.MaterialsSustainability
        ),
        PrimaryButtonItem.Documents to listOf(
            SecondaryButtonItem.Manual,
            SecondaryButtonItem.Installation,
            SecondaryButtonItem.Safety,
            SecondaryButtonItem.Policy
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
                    PlaceSearchPrimaryButtons(
                        onPrimaryButtonClick = { category ->
                            selectedCategory = category
                            setInSubCategory(true)
                        }
                    )
                } else {
                    PlaceSecondaryButtons(
                        secondaryButtons = secondaryButtons[selectedCategory] ?: emptyList(),
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
fun PlaceSearchPrimaryButtons(
    onPrimaryButtonClick: (PrimaryButtonItem) -> Unit
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
            SearchPrimaryButton(PrimaryButtonItem.Basic, onClick = { onPrimaryButtonClick(PrimaryButtonItem.Basic) })
            SearchPrimaryButton(PrimaryButtonItem.Logistics, onClick = { onPrimaryButtonClick(PrimaryButtonItem.Logistics) })
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SearchPrimaryButton(PrimaryButtonItem.Sustainability, onClick = { onPrimaryButtonClick(PrimaryButtonItem.Sustainability) })
            SearchPrimaryButton(PrimaryButtonItem.Documents, onClick = { onPrimaryButtonClick(PrimaryButtonItem.Documents) })
        }
    }
}

@Composable
private fun SearchPrimaryButton(
    primaryButtonItem: PrimaryButtonItem,
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
                painter = painterResource(id = primaryButtonItem.icon),
                contentDescription = "${primaryButtonItem.description} icon",
                modifier = Modifier
                    .size(90.dp)
                    .padding(bottom = 8.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = primaryButtonItem.description,
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
private fun PlaceSecondaryButtons(
    secondaryButtons: List<SecondaryButtonItem>,
    onNavigate: (KompassScreen) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        secondaryButtons.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowItems.forEach { secondaryButtonButton ->
                    val screen = getDetailScreenForSecondaryButton(secondaryButtonButton)
                    SecondaryButton(secondaryButtonButton, {}, onNavigate = onNavigate, 140, 225, screen)
                }
            }
        }
    }
}

fun getDetailScreenForSecondaryButton(item: SecondaryButtonItem): KompassScreen {
    return when (item) {
        SecondaryButtonItem.Specific -> KompassScreen.Home
        SecondaryButtonItem.Contents -> KompassScreen.Home
        SecondaryButtonItem.Dimensions -> KompassScreen.DetailedDimensions
        SecondaryButtonItem.MaterialsBasic -> KompassScreen.Home

        SecondaryButtonItem.Availability -> KompassScreen.DetailedAvailability
        SecondaryButtonItem.Location -> KompassScreen.Home
        SecondaryButtonItem.Delivery -> KompassScreen.Home
        SecondaryButtonItem.History -> KompassScreen.Home

        SecondaryButtonItem.Sustainability -> KompassScreen.DetailedSustainability
        SecondaryButtonItem.Description -> KompassScreen.Home
        SecondaryButtonItem.MaterialsSustainability -> KompassScreen.Home

        SecondaryButtonItem.Manual -> KompassScreen.Home
        SecondaryButtonItem.Installation -> KompassScreen.Home
        SecondaryButtonItem.Safety -> KompassScreen.Home
        SecondaryButtonItem.Policy -> KompassScreen.Home
    }
}