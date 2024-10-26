package com.example.kompass.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kompass.KompassScreen
import com.example.kompass.SecondaryButtonItem
import com.example.kompass.data.SearchItemSource
import com.example.kompass.types.ProductItem
import com.example.kompass.ui.cards.SearchCardOverlay
import com.example.kompass.ui.cards.SearchItemCard
import com.example.kompass.ui.theme.BgBlack


@Composable
fun SearchScreen(
    innerPadding: PaddingValues,
    onNavigate: (KompassScreen) -> Unit,
    onItemClicked: (SecondaryButtonItem) -> Unit
) {
    var searchQueryString by remember { mutableStateOf("") }
    var searchQueryProduct by remember { mutableStateOf<ProductItem?>(null) }
    val allItems = SearchItemSource().loadSearchItems()

    // Use the filter function
    val filteredResults = filterSearchItems(allItems, searchQueryString)
    var textFieldFocusState by remember { mutableStateOf(false) }

    var showOverlay by remember { mutableStateOf(false) }
    var inSubCategory by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BgBlack)
        ) {
            SearchBar(
                modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 10.dp),
                query = searchQueryString,
                onQueryChange = { searchQueryString = it },
                onFocusChange = { textFieldFocusState = it }
            )
            SearchItemList(
                searchItemList = filteredResults,
                onCardClick = { searchQuery ->
                    searchQueryProduct = searchQuery
                    searchQueryString = searchQuery.name
                    //textFieldFocusState = true // Trigger focus change
                    showOverlay = true
                    inSubCategory = false
                }
            )
        }

        if (showOverlay) {
            BackHandler {
                if (inSubCategory) {
                    inSubCategory = false // Go back to main categories

                }
                else {
                    showOverlay = false // Close the overlay
                }
            }

            searchQueryProduct?.let { product ->
                SearchCardOverlay(
                    onNavigate = onNavigate,
                    onItemClicked = { item ->
                        inSubCategory = true // Set to subcategories when a subcategory item is selected
                        onItemClicked(item)
                    },
                    onBackClick = { showOverlay = false }, // Also support overlay close from within
                    productItem = product,
                    inSubCategory = inSubCategory,
                    setInSubCategory = { inSubCategory = it }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onFocusChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue(query)) }

    TextField(
        value = textFieldValue,
        onValueChange = { newValue ->
            textFieldValue = newValue
            onQueryChange(newValue.text)
        },
        placeholder = { Text("Search for product or category...") },
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(24.dp)
            )
            .background(Color.Transparent, shape = RoundedCornerShape(24.dp))
            .onFocusChanged { focusState ->
                onFocusChange(focusState.isFocused)
            },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { /* Handle Done action */ }
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Gray
        ),
    )

    // Ensure the cursor is at the end of the text
    LaunchedEffect(query) {
        textFieldValue = TextFieldValue(query, TextRange(query.length))
    }
}

@Composable
fun SearchItemList(
    searchItemList: List<FilteredSearchResult>,
    onCardClick: (ProductItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(searchItemList) { searchResult ->
            SearchItemCard(
                searchItem = searchResult.item,
                onCardClick = onCardClick
            )
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}


enum class SearchResultSource {
    NAME,
    CATEGORY,
    BOTH,
    NONE
}

data class FilteredSearchResult(
    val item: ProductItem,
    val source: SearchResultSource
)

fun filterSearchItems(
    items: List<ProductItem>,
    query: String
): List<FilteredSearchResult> {
    if (query.isBlank()) return emptyList()

    return items.mapNotNull { item ->
        val isNameMatch = item.name.contains(query, ignoreCase = true)
        val isCategoryMatch = item.category.contains(query, ignoreCase = true)

        when {
            isNameMatch && isCategoryMatch -> FilteredSearchResult(item, SearchResultSource.BOTH)
            isNameMatch -> FilteredSearchResult(item, SearchResultSource.NAME)
            isCategoryMatch -> FilteredSearchResult(item, SearchResultSource.CATEGORY)
            else -> null
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    val defaultPadding = PaddingValues(0.dp)
    SearchScreen(innerPadding = defaultPadding, {}, {})
}


