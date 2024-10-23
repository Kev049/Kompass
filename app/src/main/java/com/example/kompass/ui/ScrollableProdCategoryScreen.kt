package com.example.kompass.ui

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
//        val categories = listOf(
//            CategoryItem.Availability, CategoryItem.Location,
//            CategoryItem.Delivery, CategoryItem.History
//        )
    }
}

@Composable
fun SubCategoryList(subCategoryList: List<SubCategory>, screenWidth: Int, screenHeight: Int, modifier: Modifier = Modifier){
    LazyColumn (modifier = modifier){
        items(subCategoryList) { subcategory ->
            SubCategoryCard(
                subcategory = subcategory,
                modifier = Modifier.padding(8.dp),
                screenWidth,
                screenHeight
            )
        }
    }
}

@Composable
fun SubCategoryApp(
    screenHeight: Int,
    screenWidth: Int
){
    //val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            //.fillMaxSize()
            .statusBarsPadding()
            .padding(
                PaddingValues()
                //WindowInsets.safeDrawing.asPaddingValues()
/*                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),*/
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