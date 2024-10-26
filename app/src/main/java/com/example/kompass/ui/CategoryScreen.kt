package com.example.kompass.ui

import CategoryCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.KompassScreen
import com.example.kompass.R
import com.example.kompass.data.Datasource
import com.example.kompass.types.Category
import com.example.kompass.types.CategoryData
import kotlin.math.roundToInt
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CategoryScreen(
    innerPadding: PaddingValues,
    screenWidth: Int,
    screenHeight: Int,
    imageResId: Int?,
    onNavigate: (KompassScreen, Category) -> Unit
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
    categoryDataList: List<CategoryData>,
    screenWidth: Int,
    screenHeight: Int,
    onNavigate: (KompassScreen, Category) -> Unit,
    modifier: Modifier = Modifier,
    openProductList: Boolean = false
) {
    var items by remember { mutableStateOf(categoryDataList.toMutableList()) }
    var draggedIndex by remember { mutableStateOf(-1) }
    var dropIndex by remember { mutableStateOf(-1) }
    var offset by remember { mutableStateOf(IntOffset(0, 0)) }

    val density = LocalDensity.current // Get the current density
    val gridState = rememberLazyGridState()

    LazyVerticalGrid(
        state = gridState,
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        // Function to reset drag state
        fun resetDragState() {
            draggedIndex = -1
            dropIndex = -1
            offset = IntOffset(0, 0)
        }

        items(items.size) { index ->
            val isBeingDragged = index == draggedIndex
            val isDropTarget = index == dropIndex

            CategoryCard(
                categoryData = items[index],
                screenWidth = screenWidth,
                screenHeight = screenHeight,
                onNavigate = onNavigate,
                screen = KompassScreen.SubCategory,
                openProductList = openProductList,
                modifier = Modifier
                    .padding(8.dp)
                    .pointerInput(Unit) {
                        detectDragGesturesAfterLongPress(
                            onDragStart = {
                                draggedIndex = index
                                dropIndex = index
                                offset = IntOffset(0, 0)

                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                offset = IntOffset(
                                    x = offset.x + dragAmount.x.roundToInt(),
                                    y = offset.y + dragAmount.y.roundToInt()
                                )

                                // Calculate potential drop index
                                dropIndex = calculateNewIndex(index, offset, items, density)
                            },
                            onDragEnd = {
                                // Swap items when drag ends
                                if (dropIndex != -1 && dropIndex != draggedIndex) {
                                    items = items.toMutableList().apply {
                                        val temp = this[draggedIndex]
                                        this[draggedIndex] = this[dropIndex]
                                        this[dropIndex] = temp
                                    }
                                }
                                // Reset indices and dragging state
                                resetDragState()
                            },
                            onDragCancel = {
                                resetDragState()
                            }

                        )
                    }
                    .offset { if (isBeingDragged) offset else IntOffset(0, 0) } // Apply offset only if being dragged
                    .background(if (isBeingDragged) Color.Gray else Color.Transparent) // Optional: highlight the dragged card
            ,
                isHighlighted = isDropTarget || isBeingDragged // Pass the highlight status
            )
        }
    }
}

private fun calculateNewIndex(
    currentIndex: Int,
    offset: IntOffset,
    items: List<CategoryData>, // Pass the items list
    density: Density
): Int {
    val gridWidth = 2 // Number of columns in the grid

    // Convert card dimensions to pixels
    val cardWidth = with(density) { 150.dp.toPx() }
    val cardHeight = with(density) { 150.dp.toPx() }

    // Calculate the drag position
    val dragX = offset.x + (currentIndex % gridWidth) * cardWidth + cardWidth / 2
    val dragY = offset.y + (currentIndex / gridWidth) * cardHeight + cardHeight / 2

    // Find the closest card based on the drag position
    var closestIndex = -1
    var closestDistance = Double.MAX_VALUE

    items.forEachIndexed { index, _ ->
        // Calculate center of the card
        val cardCenterX = (index % gridWidth) * cardWidth + cardWidth / 2
        val cardCenterY = (index / gridWidth) * cardHeight + cardHeight / 2

        // Calculate the distance from the drag position to the card's center
        val distance = Math.sqrt(
            Math.pow((cardCenterX - dragX).toDouble(), 2.0) +
                    Math.pow((cardCenterY - dragY).toDouble(), 2.0)
        )

        // Update the closest card if necessary
        if (distance < closestDistance) {
            closestDistance = distance
            closestIndex = index
        }
    }

    return closestIndex
}



@Composable
fun CategoryApp(
    screenWidth: Int,
    screenHeight: Int,
    innerPadding: PaddingValues,
    imageResId: Int?,
    onNavigate: (KompassScreen, Category) -> Unit
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
                categoryDataList = Datasource().loadCategories(),
                screenWidth = screenWidth,
                screenHeight = screenHeight,
                onNavigate = onNavigate,
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