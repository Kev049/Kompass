package com.example.kompass.data

import com.example.kompass.R
import com.example.kompass.types.Category
import com.example.kompass.types.CategoryData

class Datasource {
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

//    fun loadSubCategories(): List<Category> {
//        return listOf<Category>(
//            Category(R.drawable.categories_beds,"Beds", "description"),
//            Category(R.drawable.categories_beds,"Bed - mattresses", "description"),
//            Category(R.drawable.categories_beds,"Under bed storage", "description"),
//            Category(R.drawable.categories_beds,"Bed legs", "description"),
//            Category(R.drawable.categories_beds,"Bed textiles & bed sets", "description"),
//            Category(R.drawable.categories_beds,"Bedside tables", "description"),
//            Category(R.drawable.categories_beds,"Bed - Headboards", "description"),
//            Category(R.drawable.categories_beds,"Bed - Slats", "description"),
//            Category(R.drawable.categories_beds,"Bedroom furniture sets", "description"),
//
//            Category(R.drawable.categories_bathroom,"Bathroom systems", "description"),
//            Category(R.drawable.categories_bathroom,"Bathroom shelving units", "description"),
//            Category(R.drawable.categories_bathroom,"Bathroom mirrors", "description"),
//            Category(R.drawable.categories_bathroom,"Bathroom accessories", "description"),
//            Category(R.drawable.categories_bathroom,"Bathroom sinks", "description"),
//            Category(R.drawable.categories_bathroom,"Bathroom taps", "description"),
//            Category(R.drawable.categories_bathroom,"Bathroom showers", "description"),
//            Category(R.drawable.categories_bathroom,"Bathroom boxes", "description")
//        )
//    }
}
