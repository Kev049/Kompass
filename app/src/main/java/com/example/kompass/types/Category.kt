package com.example.kompass.types

import androidx.compose.ui.text.capitalize

enum class Category {
    BATHROOM_FURNITURE,
    BEDS_AND_MATTRESSES,
    DECORATION,
    FIX_AT_HOME,
    FOOD_AND_DRINKS,
    FURNITURE,
    GARDEN_FURNITURE,
    HOME_ELECTRONICS,
    KITCHEN_AND_HOUSEHOLD_APPLIANCES,
    KITCHENWARE,
    LAUNDRY_AND_CLEANING,
    LIGHTING,
    PETS,
    PLANTS_AND_CULTIVATION,
    STORAGE,
    TEXTILES;

    fun toDisplayName(): String {
        return name
            .replace("AND", "&")
            .split("_")
            .joinToString(" ") { part -> // Convert to capital letter only if first letter of combined word
                part.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            }
    }
}
