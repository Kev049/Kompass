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

    fun loadSubCategories(): List<Category> {
        return listOf<Category>(
            Category(R.drawable.categories_beds,"Beds", "description"),
            Category(R.drawable.categories_beds,"Bed - mattresses", "description"),
            Category(R.drawable.categories_beds,"Under bed storage", "description"),
            Category(R.drawable.categories_beds,"Bed legs", "description"),
            Category(R.drawable.categories_beds,"Bed textiles & bed sets", "description"),
            Category(R.drawable.categories_beds,"Bedside tables", "description"),
            Category(R.drawable.categories_beds,"Bed - Headboards", "description"),
            Category(R.drawable.categories_beds,"Bed - Slats", "description"),
            Category(R.drawable.categories_beds,"Bedroom furniture sets", "description"),

            Category(R.drawable.categories_bathroom,"Bathroom systems", "description"),
            Category(R.drawable.categories_bathroom,"Bathroom shelving units", "description"),
            Category(R.drawable.categories_bathroom,"Bathroom mirrors", "description"),
            Category(R.drawable.categories_bathroom,"Bathroom accessories", "description"),
            Category(R.drawable.categories_bathroom,"Bathroom sinks", "description"),
            Category(R.drawable.categories_bathroom,"Bathroom taps", "description"),
            Category(R.drawable.categories_bathroom,"Bathroom showers", "description"),
            Category(R.drawable.categories_bathroom,"Bathroom boxes", "description")
        )
    }
}
