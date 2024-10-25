package com.example.kompass.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.kompass.data.SearchItemSource
import com.example.kompass.types.SearchItemInfo
import com.example.kompass.ui.cards.SearchItemCard


@Composable
fun SearchScreen(innerPadding: PaddingValues) {
    var searchQuery by remember { mutableStateOf("") }
    val allItems = SearchItemSource().loadSearchItems()

    // Use the filter function
    val filteredResults = filterSearchItems(allItems, searchQuery)
    var textFieldFocusState by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onFocusChange = { textFieldFocusState = it }
            )
            SearchItemList(
                searchItemList = filteredResults,
                onCardClick = { name ->
                    searchQuery = name
                    textFieldFocusState = true // Trigger focus change
                }
            )
        }
    }
}

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
            .onFocusChanged { focusState ->
                onFocusChange(focusState.isFocused)
            },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { /* Handle Done action */ }
        )
    )

    // Ensure the cursor is at the end of the text
    LaunchedEffect(query) {
        textFieldValue = TextFieldValue(query, TextRange(query.length))
    }
}

@Composable
fun SearchItemList(
    searchItemList: List<FilteredSearchResult>,
    onCardClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(searchItemList) { searchResult ->
            SearchItemCard(
                searchItem = searchResult.item,
                modifier = Modifier.fillMaxWidth(),
                onCardClick = onCardClick
            )
            Spacer(modifier = Modifier.padding(4.dp))
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
    val item: SearchItemInfo,
    val source: SearchResultSource
)

fun filterSearchItems(
    items: List<SearchItemInfo>,
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

