package com.example.kompass.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kompass.CategoryItem
import com.example.kompass.NavButtons
import com.example.kompass.types.SubCategory
import com.example.kompass.ui.cards.SubCategoryCard
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import com.example.kompass.data.Datasource


@Composable
fun ScrollableProdCategoryScreen(
    innerPadding: PaddingValues,
    navController: NavController,
    screenWidth: Int,
    screenHeight: Int
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.TopCenter
    ) { SubCategoryApp(screenWidth, screenHeight)
    }
}

@Composable
fun SubCategoryList(
    subCategoryList: List<SubCategory>,
    screenWidth: Int,
    screenHeight: Int,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        modifier = Modifier.fillMaxSize()
        //contentPadding = PaddingValues(8.dp)
    ) {
        items(subCategoryList) { subcategory ->
            SubCategoryCard(
                subcategory = subcategory,
                screenWidth = screenWidth,
                screenHeight = screenHeight,
                modifier = Modifier.padding(8.dp)
                 // Padding between cards
            )
        }
    }
}

@Composable
fun SubCategoryApp(
    screenWidth: Int,
    screenHeight: Int
){
    //val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            //.fillMaxSize()
            .statusBarsPadding()
            .padding(
                PaddingValues()
            ),
    ) {
        SubCategoryList(
            subCategoryList = Datasource().loadSubCategories(),
            screenWidth = screenWidth,
            screenHeight = screenHeight
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScrollableProdCategoryScreen() {
    val navController = rememberNavController();
    val defaultPadding = PaddingValues(0.dp)

    ScrollableProdCategoryScreen(defaultPadding, navController = navController, 320, 668)
}


//ScrollableProdCategoryScreen(innerPadding = defaultPadding, navController = navController, 320, 668)