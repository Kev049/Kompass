package com.example.kompass.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kompass.CategoryItem
import com.example.kompass.NavButtons

@Composable
fun BasicInfoScreen(
    innerPadding: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding), // Avoid overlap with BottomAppBar
        contentAlignment = Alignment.Center
    ) {
        val categories = listOf(
            CategoryItem.Dimensions, CategoryItem.Contents,
            CategoryItem.Specific, CategoryItem.Materials
        )
        NavButtons(categories, {})
    }
}


@Preview(showBackground = true)
@Composable
private fun InfoScreenPreview(
) {
    BasicInfoScreen(
            PaddingValues()
        )
}
