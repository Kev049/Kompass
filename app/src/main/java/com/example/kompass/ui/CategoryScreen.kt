package com.example.kompass.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kompass.types.Category
import com.example.kompass.ui.cards.CategoryCard
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.kompass.KompassScreen
import com.example.kompass.R
import com.example.kompass.data.Datasource

@Composable
fun CategoryScreen(
    innerPadding: PaddingValues,
    screenWidth: Int,
    screenHeight: Int,
    imageResId: Int?,
    onNavigate: (KompassScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) { CategoryApp(screenWidth, screenHeight, innerPadding, imageResId, onNavigate)
    }
}

@Composable
fun CategoryList(
    categoryList: List<Category>,
    screenWidth: Int,
    screenHeight: Int,
    onNavigate: (KompassScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(categoryList) { category ->
            CategoryCard(
                category = category,
                screenWidth = screenWidth,
                screenHeight = screenHeight,
                onNavigate = onNavigate,
                screen = KompassScreen.SubCategory,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun CategoryApp(
    screenWidth: Int,
    screenHeight: Int,
    innerPadding: PaddingValues,
    imageResId: Int?,
    onNavigate: (KompassScreen) -> Unit
){
    val imageId = imageResId ?: R.drawable.navbar_home
    //val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                innerPadding
            ),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Add the header area above the CategoryList
            Header(
                screenWidth = screenWidth,
                imageId,
                "Categories"
            )
            // Add a divider below the header
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            CategoryList(
                categoryList = Datasource().loadCategories(),
                screenWidth = screenWidth,
                screenHeight = screenHeight,
                onNavigate = onNavigate
            )
        }
    }
}

@Composable
fun Header(screenWidth: Int, imageResId: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), // Adjust the padding as needed
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween // Space between the text and image
    ) {
        Text(
            text = title, // Replace with your desired text
            fontSize = 24.sp,
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

//@Preview(showBackground = true)
//@Composable
//fun PreviewScrollableProdCategoryScreen() {
//    val navController = rememberNavController();
//    val defaultPadding = PaddingValues(0.dp)
//
//    ScrollableProdCategoryScreen(defaultPadding, navController = navController, 320, 668)
//}

//ScrollableProdCategoryScreen(innerPadding = defaultPadding, navController = navController, 320, 668)