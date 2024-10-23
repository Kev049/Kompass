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
import com.example.kompass.CategoryItem
import com.example.kompass.NavButtons

@Composable
fun DocumentsScreen(
    innerPadding: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        val categories = listOf(
            CategoryItem.Manual, CategoryItem.Installation,
            CategoryItem.Safety, CategoryItem.Policy
        )
        NavButtons(categories) {}
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDocumentsScreen() {
    val defaultPadding = PaddingValues(0.dp)
    DocumentsScreen(innerPadding = defaultPadding)
}
