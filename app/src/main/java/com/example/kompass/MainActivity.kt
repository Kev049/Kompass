package com.example.kompass

import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.kompass.ui.theme.KompassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            ScaffoldCreation()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        return true
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ScaffoldCreation() {
        var searchQuery by remember { mutableStateOf("") } // State for search query
        var expanded by remember { mutableStateOf(false) }

        val suggestions = listOf("Product Info", "Installation", "Logistics & Delivery", "Policy")
        val filteredSuggestions = suggestions.filter {
            it.contains(searchQuery, ignoreCase = true)
        }


        KompassTheme {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            TextField(
                                value = searchQuery,
                                onValueChange = {
                                    searchQuery = it
                                    expanded = it.isNotEmpty()
                                },
                                placeholder = { Text("Search for products or categories...") },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.White,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                )
                            )
                        },

                        actions = {
                            IconButton(onClick = { /* Handle search action */ }) {
                                Icon(Icons.Default.Search, contentDescription = "Search")
                            }
                        }
                    )
                },
                bottomBar = {
                    BottomAppBar(
                        containerColor = Color.Blue,
                        contentColor = Color.Yellow,
                    ) {
                        Text(
                            modifier = Modifier.fillMaxSize(),
                            text = "Navbar",
                            textAlign = TextAlign.Center,
                            fontSize = 10.em,
                        )
                    }
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding), // Avoid overlap with BottomAppBar
                    contentAlignment = Alignment.Center
                ) {
                    NavButtons()

                    // DropdownMenu for suggestions
                    DropdownMenu(
                        expanded = expanded && filteredSuggestions.isNotEmpty(),
                        onDismissRequest = { expanded = false }
                    ) {
                        filteredSuggestions.forEach { suggestion ->
                            DropdownMenuItem(onClick = {
                                searchQuery = suggestion // Set the clicked suggestion
                                expanded = false // Hide dropdown
                            }, text = {
                                Text(suggestion)
                            })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryBtn("Product Info", Color.Black)
            CategoryBtn("Installation", Color.Black)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryBtn("Logistics & Delivery", Color.Black)
            CategoryBtn("Policy", Color.Black)
        }
    }
}

@Composable
fun CategoryBtn(text: String, color: Color) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(320.dp)
            .background(color, shape = RoundedCornerShape(8.dp))
            .clickable { println("$text button Clicked") },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}