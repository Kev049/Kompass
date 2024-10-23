package com.example.kompass.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kompass.CategoryItem
import com.example.kompass.NavButtons

@Composable
fun ScrollableProdCategoryScreen(
    innerPadding: PaddingValues,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
//        val categories = listOf(
//            CategoryItem.Availability, CategoryItem.Location,
//            CategoryItem.Delivery, CategoryItem.History
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScrollableProdCategoryScreen() {
    val navController = rememberNavController();
    val defaultPadding = PaddingValues(0.dp)
    ScrollableProdCategoryScreen(innerPadding = defaultPadding, navController = navController)
}