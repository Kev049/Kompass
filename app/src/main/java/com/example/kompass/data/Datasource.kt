package com.example.kompass.data;

import com.example.kompass.R
import com.example.kompass.types.CategoryData;

public class Datasource {
    fun loadCategories(): List<CategoryData> {
        return listOf<CategoryData>(
            CategoryData(R.drawable.navbar_home,"Bathroom furniture", "description"),
            CategoryData(R.drawable.furniture,"Beds & Mattresses", "description"),
            CategoryData(R.drawable.menu_main_sustainability, "Decoration", "description"),
            CategoryData(R.drawable.menu_basic_materials, "Fix at home", "description"),
            CategoryData(R.drawable.navbar_home,"Food & Drinks", "description"),
            CategoryData(R.drawable.navbar_qr,"Furniture", "description"),
            CategoryData(R.drawable.menu_main_sustainability, "Garden Furniture", "description"),
            CategoryData(R.drawable.menu_basic_materials, "Home electronics", "description"),
            CategoryData(R.drawable.navbar_home,"Kitchen & Household appliances?", "description"),
            CategoryData(R.drawable.navbar_qr,"Kitchenware", "description"),
            CategoryData(R.drawable.menu_main_sustainability, "Laundry & Cleaning", "description"),
            CategoryData(R.drawable.menu_basic_materials, "Lighting", "description"),
            CategoryData(R.drawable.navbar_home,"Pets", "description"),
            CategoryData(R.drawable.navbar_qr,"Plants & Cultivation", "description"),
            CategoryData(R.drawable.menu_main_sustainability, "Storage", "description"),
            CategoryData(R.drawable.menu_basic_materials, "Textiles", "description")
        )
    }
}
