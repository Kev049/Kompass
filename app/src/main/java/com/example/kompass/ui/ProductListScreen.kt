package com.example.kompass.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.KompassScreen
import com.example.kompass.R
import com.example.kompass.SecondaryButtonItem
import com.example.kompass.data.Datasource
import com.example.kompass.data.SearchItemSource
import com.example.kompass.types.Category
import com.example.kompass.types.ProductItem
import com.example.kompass.ui.cards.SearchItemCard

@Composable
fun ProductListScreen(
    innerPadding: PaddingValues,
    imageResId: Int?,
    onNavigate: (KompassScreen) -> Unit,
    onItemClicked: (ProductItem) -> Unit,
    secondaryButton: SecondaryButtonItem,
    category: Category
) {
    val productItems = getSearchItemsByCategory(SearchItemSource().loadSearchItems(), category)
    val secondaryButtonScreen = Datasource().getDetailScreenForSecondaryButton(secondaryButton)
    Log.d("Button", secondaryButtonScreen.toString())

    //val productItems = SearchItemSource().loadSearchItems()
    val imageId = imageResId ?: R.drawable.navbar_home
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ProductHeader(
                imageId,
                headerText = category.toDisplayName()
            )
            // Add a divider below the header
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            ProductList(productItems, secondaryButtonScreen, onNavigate, onItemClicked)
        }
    }
}

@Composable
fun ProductList(
    productItems: List<ProductItem>,
    secondaryButtonScreen: KompassScreen,
    onNavigate: (KompassScreen) -> Unit,
    onItemClicked: (ProductItem) -> Unit
){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(productItems) { productItem ->
            SearchItemCard(
                searchItem = productItem,
                onCardClick = { onNavigate(secondaryButtonScreen)
                onItemClicked(productItem)}
            )
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}

@Composable
private fun ProductHeader(
    imageResId: Int,
    headerText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), // Adjust the padding as needed
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween // Space between the text and image,
    ) {
        Text(
            text = headerText, // Replace with your desired text
            fontSize = 24.sp,
            color = Color.White,
            //style = MaterialTheme.typography.h6, // Adjust text style as needed
            modifier = Modifier.weight(1f) // Ensure the text takes up remaining space on the left
        )

        // Image on the right
        Image(
            painter = painterResource(id = imageResId), // Replace with your image resource
            contentDescription = "Header Image",
            modifier = Modifier.size(64.dp) // Adjust the size of the image as needed
        )
    }
}