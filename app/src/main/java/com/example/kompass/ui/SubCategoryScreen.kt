package com.example.kompass.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kompass.KompassScreen
import com.example.kompass.R
import com.example.kompass.data.CategorySource
import com.example.kompass.types.Category
import com.example.kompass.types.CategoryData
import com.example.kompass.types.ProductItem

@Composable
fun SubCategoryScreen(
    innerPadding: PaddingValues,
    screenWidth: Int,
    screenHeight: Int,
    imageResId: Int?,
    category: Category,
    onNavigate: (KompassScreen, Category) -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) { SubCategoryApp(screenWidth, screenHeight, innerPadding, imageResId,category, onNavigate)
    }
}

@Composable
fun SubCategoryApp(
    screenWidth: Int,
    screenHeight: Int,
    innerPadding: PaddingValues,
    imageResId: Int?,
    category: Category,
    //title: String,
    onNavigate: (KompassScreen, Category) -> Unit
){
    val imageId = imageResId ?: R.drawable.navbar_home
    //val subCategoryItems = CategorySource().loadCategories()
    val subCategoryItems = getSubCategoriesByCategory(CategorySource().loadSubCategories(), category)
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
                title = getStringAfterDelimiter( category.toDisplayName())
            )
            // Add a divider below the header
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            CategoryList(
                categoryDataList = subCategoryItems,
                //categoryDataList = CategorySource().loadCategories(),
                screenWidth = screenWidth,
                screenHeight = screenHeight,
                onNavigate = onNavigate,
                openProductList = true
            )
        }
    }
}

fun getSubCategoriesByCategory(
    items: List<CategoryData>,
    category: Category
): List<CategoryData> {
    return items.filter { it.category.toDisplayName().contains(category.toDisplayName())}
}

fun getStringAfterDelimiter(input: String): String {
    val delimiter = " > "
    return if (input.contains(delimiter)) {
        input
            .substringAfter(delimiter)
            .replaceFirstChar { it.uppercase() }
    } else {
        input // or you can return an empty string if preferred
    }
}
