package com.example.kompass.data;

import com.example.kompass.R
import com.example.kompass.types.Category;

public class Datasource {
    fun loadCategories(): List<Category> {
        return listOf<Category>(
            Category(R.drawable.categories_bathroom,"Bathroom furniture", "description"),
            Category(R.drawable.categories_beds,"Beds & Mattresses", "description"),
            Category(R.drawable.categories_decoration, "Decoration", "description"),
            Category(R.drawable.categories_home_improvement, "Fix at home", "description"),
            Category(R.drawable.categories_food,"Food & Drinks", "description"),
            Category(R.drawable.categories_furniture,"Furniture", "description"),
            Category(R.drawable.categories_garden_furniture, "Garden Furniture", "description"),
            Category(R.drawable.categories_electronics, "Home electronics", "description"),
            Category(R.drawable.categories_kitchen,"Kitchen & Household appliances", "description"),
            Category(R.drawable.categories_kitchenware,"Kitchenware", "description"),
            Category(R.drawable.categories_laundry, "Laundry & Cleaning", "description"),
            Category(R.drawable.categories_lighting, "Lighting", "description"),
            Category(R.drawable.categories_pets,"Pets", "description"),
            Category(R.drawable.categories_plants,"Plants & Cultivation", "description"),
            Category(R.drawable.categories_storage, "Storage", "description"),
            Category(R.drawable.categories_textiles, "Textiles", "description")
        )
    }
}
