package com.example.kompass.ui

import androidx.compose.foundation.layout.Box
<<<<<<< HEAD
import androidx.compose.foundation.layout.PaddingValues
=======
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
>>>>>>> 9b267aeee74af83d8caffb06ba4ef3d5d3202e8b
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kompass.CategoryItem
import com.example.kompass.NavButtons

@Composable
fun BasicInfoScreen(
    innerPadding: PaddingValues
) {
<<<<<<< HEAD
=======
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


@Composable
fun CategoryBtn2(
    categoryItem: CategoryItem, )
{
>>>>>>> 9b267aeee74af83d8caffb06ba4ef3d5d3202e8b
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        val categories = listOf(
            CategoryItem.Dimensions, CategoryItem.Contents,
            CategoryItem.Specific, CategoryItem.Materials
        )
        NavButtons(categories) {}
    }
}

@Preview(showBackground = true)
@Composable
<<<<<<< HEAD
fun PreviewBasicInfoScreen() {
    val defaultPadding = PaddingValues(0.dp)
    BasicInfoScreen(innerPadding = defaultPadding)
=======
private fun InfoScreenPreview(
) {
    KompassTheme {
        BasicInfoScreen(
            PaddingValues()
        )
    }
>>>>>>> 9b267aeee74af83d8caffb06ba4ef3d5d3202e8b
}
