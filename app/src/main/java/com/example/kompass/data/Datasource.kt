package com.example.kompass.data;

import com.example.kompass.R
import com.example.kompass.types.Category;

public class Datasource {
    fun loadCategories(): List<Category> {
        return listOf<Category>(
            Category(R.drawable.navbar_home,"Bathroom furniture", "description"),
            Category(R.drawable.furniture,"Beds & Matresses", "description"),
            Category(R.drawable.menu_main_sustainability, "Decoration", "description"),
            Category(R.drawable.menu_basic_materials, "Fix at home", "description"),
            Category(R.drawable.navbar_home,"Food & Drinks", "description"),
            Category(R.drawable.navbar_qr,"Furniture", "description"),
            Category(R.drawable.menu_main_sustainability, "Garden Furniture", "description"),
            Category(R.drawable.menu_basic_materials, "Home electronics", "description"),
            Category(R.drawable.navbar_home,"Kitchen & Household appliances?", "description"),
            Category(R.drawable.navbar_qr,"Kitchenware", "description"),
            Category(R.drawable.menu_main_sustainability, "Laundry & Cleaning", "description"),
            Category(R.drawable.menu_basic_materials, "Lighting", "description"),
            Category(R.drawable.navbar_home,"Pets", "description"),
            Category(R.drawable.navbar_qr,"Plants & Cultivation", "description"),
            Category(R.drawable.menu_main_sustainability, "Storage", "description"),
            Category(R.drawable.menu_basic_materials, "Textiles", "description")
        )
    }
}
