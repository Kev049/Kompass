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
    KITCHEN_AND_APPLIANCES,
    KITCHENWARE,
    LAUNDRY_AND_CLEANING,
    LIGHTING,
    PETS,
    PLANTS_AND_CULTIVATION,
    STORAGE,
    TEXTILES,

    BEDS_AND_MATTRESSES_S_MATTRESSES,
    BEDS_AND_MATTRESSES_S_BEDS,
    BEDS_AND_MATTRESSES_S_UNDER_BED_STORAGE,
    BEDS_AND_MATTRESSES_S_BED_LEGS,
    BEDS_AND_MATTRESSES_S_BED_TEXTILES_AND_SETS,
    BEDS_AND_MATTRESSES_S_BEDSIDE_TABLES,
    BEDS_AND_MATTRESSES_S_HEADBOARDS,
    BEDS_AND_MATTRESSES_S_SLATS,
    BEDS_AND_MATTRESSES_S_BEDROOM_FURNITURE_SETS,
    BEDS_AND_MATTRESSES_S_BED_FRAMES,

    BATHROOM_FURNITURE_S_BATHROOM_SYSTEMS,
    BATHROOM_FURNITURE_S_BATHROOM_SHELVING_UNITS,
    BATHROOM_FURNITURE_S_MIRRORS,
    BATHROOM_FURNITURE_S_BATHROOM_ACCESSORIES,
    BATHROOM_FURNITURE_S_SINKS,
    BATHROOM_FURNITURE_S_TAPS,
    BATHROOM_FURNITURE_S_SHOWERS,
    BATHROOM_FURNITURE_S_BOXES
    ;

    // Example: "KITCHEN_AND_HOUSEHOLD_APPLIANCES" --> "Kitchen & household appliances"
    fun toDisplayName(): String {
        return name
            .replace("AND", "&")
            .replace("_S_", " > ")
            .split("_")
            .joinToString(" ")
            .lowercase()
            .replaceFirstChar { it.uppercase() }
    }
}