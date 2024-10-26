package com.example.kompass.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface
import androidx.compose.material3.HorizontalDivider
import com.example.kompass.KompassScreen
import com.example.kompass.R
import com.example.kompass.data.Datasource

@Composable
fun SubCategoryScreen(
    innerPadding: PaddingValues,
    screenWidth: Int,
    screenHeight: Int,
    imageResId: Int?,
    onNavigate: (KompassScreen, String) -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) { SubCategoryApp(screenWidth, screenHeight, innerPadding, imageResId, onNavigate)
    }
}

@Composable
fun SubCategoryApp(
    screenWidth: Int,
    screenHeight: Int,
    innerPadding: PaddingValues,
    imageResId: Int?,
    //title: String, TODO: Ska lägga till
    onNavigate: (KompassScreen, String) -> Unit
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
                "placeholder"
            )
            // Add a divider below the header
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            CategoryList(
                categoryList = Datasource().loadSubCategories(),
                screenWidth = screenWidth,
                screenHeight = screenHeight,
                onNavigate = onNavigate,
                openProductList = true
            )
        }
    }
}