package com.example.kompass.data;

import com.example.kompass.R
import com.example.kompass.types.SubCategory;

public class Datasource {
    fun loadSubCategories(): List<SubCategory> {
        return listOf<SubCategory>(
            SubCategory(R.drawable.navbar_home,"Bathroom furniture", "description"),
            SubCategory(R.drawable.navbar_qr,"Beds & Matresses", "description"),
            SubCategory(R.drawable.menu_main_sustainability, "Decoration", "description"),
            SubCategory(R.drawable.menu_basic_materials, "Fix at home", "description"),
            SubCategory(R.drawable.navbar_home,"Food & Drinks", "description"),
            SubCategory(R.drawable.navbar_qr,"Furniture", "description"),
            SubCategory(R.drawable.menu_main_sustainability, "Garden Furniture", "description"),
            SubCategory(R.drawable.menu_basic_materials, "Home electronics", "description"),
            SubCategory(R.drawable.navbar_home,"Kitchen & Household appliances?", "description"),
            SubCategory(R.drawable.navbar_qr,"Kitchenware", "description"),
            SubCategory(R.drawable.menu_main_sustainability, "Laundry & Cleaning", "description"),
            SubCategory(R.drawable.menu_basic_materials, "Lighting", "description"),
            SubCategory(R.drawable.navbar_home,"Pets", "description"),
            SubCategory(R.drawable.navbar_qr,"Plants & Cultivation", "description"),
            SubCategory(R.drawable.menu_main_sustainability, "Storage", "description"),
            SubCategory(R.drawable.menu_basic_materials, "Textiles", "description")
        )
    }
}
