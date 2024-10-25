package com.example.kompass.ui

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
import com.example.kompass.data.SearchItemSource
import com.example.kompass.types.ProductItem
import com.example.kompass.ui.cards.SearchItemCard

@Composable
fun ProductListScreen(
    innerPadding: PaddingValues,
    imageResId: Int?,
    onNavigate: (KompassScreen) -> Unit
) {
    val productItems = SearchItemSource().loadSearchItems()
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
                imageId
            )
            // Add a divider below the header
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            ProductList(productItems)
        }
    }
}

@Composable
fun ProductList(
    productItems: List<ProductItem>
){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(productItems) { productItem ->
            SearchItemCard(
                searchItem = productItem,
                modifier = Modifier.fillMaxWidth(),
                onCardClick = { }
            )
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}

@Composable
private fun ProductHeader(imageResId: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), // Adjust the padding as needed
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween // Space between the text and image
    ) {
        Text(
            text = "Furniture", // Replace with your desired text
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

@Preview(showBackground = true)
@Composable
fun PreviewProductListScreen() {
    val defaultPadding = PaddingValues(0.dp)
    ProductListScreen(innerPadding = defaultPadding, imageResId = R.drawable.navbar_home, onNavigate = {})
}