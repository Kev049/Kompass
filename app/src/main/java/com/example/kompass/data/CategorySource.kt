package com.example.kompass.data

import com.example.kompass.KompassScreen
import com.example.kompass.R
import com.example.kompass.SecondaryButtonItem
import com.example.kompass.types.Category
import com.example.kompass.types.CategoryData

class CategorySource {
    fun loadCategories(): List<CategoryData> {
        return listOf(
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, Category.BATHROOM_FURNITURE.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, Category.BEDS_AND_MATTRESSES.toDisplayName()),

            CategoryData(R.drawable.categories_home_improvement, Category.HOME_IMPROVEMENT, Category.HOME_IMPROVEMENT.toDisplayName()),
            CategoryData(R.drawable.categories_food, Category.FOOD_AND_DRINKS, Category.FOOD_AND_DRINKS.toDisplayName()),
            CategoryData(R.drawable.categories_furniture, Category.FURNITURE, Category.FURNITURE.toDisplayName()),
            CategoryData(R.drawable.categories_garden_furniture, Category.GARDEN_FURNITURE, Category.GARDEN_FURNITURE.toDisplayName()),
            CategoryData(R.drawable.categories_electronics, Category.HOME_ELECTRONICS, Category.HOME_ELECTRONICS.toDisplayName()),
            CategoryData(R.drawable.categories_kitchen, Category.KITCHEN_AND_APPLIANCES, Category.KITCHEN_AND_APPLIANCES.toDisplayName()),
            CategoryData(R.drawable.categories_kitchenware, Category.KITCHENWARE, Category.KITCHENWARE.toDisplayName()),
            CategoryData(R.drawable.categories_laundry, Category.LAUNDRY_AND_CLEANING, Category.LAUNDRY_AND_CLEANING.toDisplayName()),
            CategoryData(R.drawable.categories_lighting, Category.LIGHTING, Category.LIGHTING.toDisplayName()),
            CategoryData(R.drawable.categories_pets, Category.PETS, Category.PETS.toDisplayName()),
            CategoryData(R.drawable.categories_decoration, Category.DECORATION, Category.DECORATION.toDisplayName()),
            CategoryData(R.drawable.categories_plants, Category.PLANTS_AND_CULTIVATION, Category.PLANTS_AND_CULTIVATION.toDisplayName()),
            CategoryData(R.drawable.categories_storage, Category.STORAGE, Category.STORAGE.toDisplayName()),
            CategoryData(R.drawable.categories_textiles, Category.TEXTILES, Category.TEXTILES.toDisplayName())
        )
    }

    fun loadSubCategories(): List<CategoryData> {
        return listOf<CategoryData>(
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_BEDS, Category.BEDS_AND_MATTRESSES_S_BEDS.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_MATTRESSES, Category.BEDS_AND_MATTRESSES_S_MATTRESSES.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_UNDER_BED_STORAGE, Category.BEDS_AND_MATTRESSES_S_UNDER_BED_STORAGE.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_BED_LEGS, Category.BEDS_AND_MATTRESSES_S_BED_LEGS.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_BED_TEXTILES_AND_SETS, Category.BEDS_AND_MATTRESSES_S_BED_TEXTILES_AND_SETS.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_BEDSIDE_TABLES, Category.BEDS_AND_MATTRESSES_S_BEDSIDE_TABLES.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_HEADBOARDS, Category.BEDS_AND_MATTRESSES_S_HEADBOARDS.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_SLATS, Category.BEDS_AND_MATTRESSES_S_SLATS.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_BEDROOM_FURNITURE_SETS, Category.BEDS_AND_MATTRESSES_S_BEDROOM_FURNITURE_SETS.toDisplayName()),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES_S_BED_FRAMES, Category.BEDS_AND_MATTRESSES_S_BED_FRAMES.toDisplayName()),
            // divider, above: Category.BEDS_AND_MATTRESSES, below: Category.BATHROOM_FURNITURE
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE_S_BATHROOM_SYSTEMS, Category.BATHROOM_FURNITURE_S_BATHROOM_SYSTEMS.toDisplayName()),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE_S_BATHROOM_SHELVING_UNITS, Category.BATHROOM_FURNITURE_S_BATHROOM_SHELVING_UNITS.toDisplayName()),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE_S_MIRRORS, Category.BATHROOM_FURNITURE_S_MIRRORS.toDisplayName()),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE_S_BATHROOM_ACCESSORIES, Category.BATHROOM_FURNITURE_S_BATHROOM_ACCESSORIES.toDisplayName()),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE_S_SINKS, Category.BATHROOM_FURNITURE_S_SINKS.toDisplayName()),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE_S_TAPS, Category.BATHROOM_FURNITURE_S_TAPS.toDisplayName()),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE_S_SHOWERS, Category.BATHROOM_FURNITURE_S_SHOWERS.toDisplayName()),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE_S_BOXES, Category.BATHROOM_FURNITURE_S_BOXES.toDisplayName())

        )
    }
    fun getDetailScreenForSecondaryButton(item: SecondaryButtonItem): KompassScreen {
        return when (item) {
            SecondaryButtonItem.Specific -> KompassScreen.DetailedProductSpecifics
            SecondaryButtonItem.Contents -> KompassScreen.DetailedContents
            SecondaryButtonItem.Dimensions -> KompassScreen.DetailedDimensions
            SecondaryButtonItem.MaterialsBasic -> KompassScreen.DetailedMaterials

            SecondaryButtonItem.Availability -> KompassScreen.DetailedAvailability
            SecondaryButtonItem.Location -> KompassScreen.Home
            SecondaryButtonItem.Delivery -> KompassScreen.Home
            SecondaryButtonItem.History -> KompassScreen.Home

            SecondaryButtonItem.Sustainability -> KompassScreen.DetailedSustainability
            SecondaryButtonItem.Description -> KompassScreen.Home
            SecondaryButtonItem.MaterialsSustainability -> KompassScreen.Home

            SecondaryButtonItem.Manual -> KompassScreen.Home
            SecondaryButtonItem.Installation -> KompassScreen.Home
            SecondaryButtonItem.Safety -> KompassScreen.Home
            SecondaryButtonItem.Policy -> KompassScreen.Home
        }
    }
}
