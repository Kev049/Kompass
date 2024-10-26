package com.example.kompass.types

enum class Category {
    NONE,
    BATHROOM_FURNITURE,
    BEDS_AND_MATTRESSES,
    DECORATION,
    HOME_IMPROVEMENT,
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
    TEXTILES,


    ;

    // Example: "KITCHEN_AND_HOUSEHOLD_APPLIANCES" --> "Kitchen & household appliances"
    fun toDisplayName(): String {
        return name
            .replace("AND", "&")
            .split("_")
            .joinToString(" ")
            .lowercase()
            .replaceFirstChar { it.uppercase() }
    }
}
