package com.example.kompass.data

import com.example.kompass.R
import com.example.kompass.types.Category
import com.example.kompass.types.CategoryData

class CategorySource {
    fun loadCategories(): List<CategoryData> {
        return listOf(
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, "description"),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "description"),
            CategoryData(R.drawable.categories_decoration, Category.DECORATION, "description"),
            CategoryData(R.drawable.categories_home_improvement, Category.HOME_IMPROVEMENT, "description"),
            CategoryData(R.drawable.categories_food, Category.FOOD_AND_DRINKS, "description"),
            CategoryData(R.drawable.categories_furniture, Category.FURNITURE, "description"),
            CategoryData(R.drawable.categories_garden_furniture, Category.GARDEN_FURNITURE, "description"),
            CategoryData(R.drawable.categories_electronics, Category.HOME_ELECTRONICS, "description"),
            CategoryData(R.drawable.categories_kitchen, Category.KITCHEN_AND_HOUSEHOLD_APPLIANCES, "description"),
            CategoryData(R.drawable.categories_kitchenware, Category.KITCHENWARE, "description"),
            CategoryData(R.drawable.categories_laundry, Category.LAUNDRY_AND_CLEANING, "description"),
            CategoryData(R.drawable.categories_lighting, Category.LIGHTING, "description"),
            CategoryData(R.drawable.categories_pets, Category.PETS, "description"),
            CategoryData(R.drawable.categories_plants, Category.PLANTS_AND_CULTIVATION, "description"),
            CategoryData(R.drawable.categories_storage, Category.STORAGE, "description"),
            CategoryData(R.drawable.categories_textiles, Category.TEXTILES, "description")
        )
    }

    fun loadSubCategories(): List<CategoryData> {
        return listOf<CategoryData>(
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "Beds"),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "Bed - mattresses"),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "Under bed storage"),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "Bed legs"),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "Bed textiles & bed sets"),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "Bedside tables"),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "Bed - Headboards"),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "Bed - Slats"),
            CategoryData(R.drawable.categories_beds, Category.BEDS_AND_MATTRESSES, "Bedroom furniture sets"),
            // divider, above: Category.BEDS_AND_MATTRESSES, below: Category.BATHROOM_FURNITURE
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, "Bathroom systems"),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, "Bathroom shelving units"),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, "Bathroom mirrors"),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, "Bathroom accessories"),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, "Bathroom sinks"),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, "Bathroom taps"),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, "Bathroom showers"),
            CategoryData(R.drawable.categories_bathroom, Category.BATHROOM_FURNITURE, "Bathroom boxes")


        )
    }
}
