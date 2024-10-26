package com.example.kompass.data

import com.example.kompass.R
import com.example.kompass.types.Category
import com.example.kompass.types.CategoryData

class Datasource {
    fun loadCategories(): List<CategoryData> {
        return listOf(
            CategoryData(R.drawable.navbar_home, Category.BATHROOM_FURNITURE, "description"),
            CategoryData(R.drawable.furniture, Category.BEDS_AND_MATTRESSES, "description"),
            CategoryData(R.drawable.menu_main_sustainability, Category.DECORATION, "description"),
            CategoryData(R.drawable.menu_basic_materials, Category.HOME_IMPROVEMENT, "description"),
            CategoryData(R.drawable.navbar_home, Category.FOOD_AND_DRINKS, "description"),
            CategoryData(R.drawable.navbar_qr, Category.FURNITURE, "description"),
            CategoryData(R.drawable.menu_main_sustainability, Category.GARDEN_FURNITURE, "description"),
            CategoryData(R.drawable.menu_basic_materials, Category.HOME_ELECTRONICS, "description"),
            CategoryData(R.drawable.navbar_home, Category.KITCHEN_AND_HOUSEHOLD_APPLIANCES, "description"),
            CategoryData(R.drawable.navbar_qr, Category.KITCHENWARE, "description"),
            CategoryData(R.drawable.menu_main_sustainability, Category.LAUNDRY_AND_CLEANING, "description"),
            CategoryData(R.drawable.menu_basic_materials, Category.LIGHTING, "description"),
            CategoryData(R.drawable.navbar_home, Category.PETS, "description"),
            CategoryData(R.drawable.navbar_qr, Category.PLANTS_AND_CULTIVATION, "description"),
            CategoryData(R.drawable.menu_main_sustainability, Category.STORAGE, "description"),
            CategoryData(R.drawable.menu_basic_materials, Category.TEXTILES, "description")
        )
    }
}
