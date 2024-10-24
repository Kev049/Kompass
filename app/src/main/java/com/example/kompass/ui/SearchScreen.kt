package com.example.kompass.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kompass.data.SearchItemSource
import com.example.kompass.types.SearchItemInfo
import com.example.kompass.ui.cards.SearchItemCard

@Composable
fun SearchScreen(
    innerPadding: PaddingValues
) {
    var searchQuery by remember { mutableStateOf("") }
    val allItems = SearchItemSource().loadSearchItems()
    val filteredItems = allItems.filter {
        it.name.contains(searchQuery, ignoreCase = true) // Assuming SearchItemInfo has a 'name' property
    }

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
                onQueryChange = { searchQuery = it }
            )
            SearchItemList(
                searchItemList = filteredItems
            )
        }
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = { Text("Search...") },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        singleLine = true
    )
}

@Composable
fun SearchItemList(
    searchItemList: List<SearchItemInfo>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp) // Add padding to the LazyColumn
    ) {
        items(searchItemList) { searchItem ->
            SearchItemCard(
                searchItem = searchItem,
                modifier = Modifier.padding(vertical = 4.dp) // Vertical padding between cards
            ) { }
        }
    }
}
