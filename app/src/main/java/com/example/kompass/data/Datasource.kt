package com.example.kompass.data;


import com.example.kompass.R
import com.example.kompass.types.SubCategory;

public class Datasource {
    fun loadSubCategories(): List<SubCategory> {
        return listOf<SubCategory>(
            SubCategory(R.drawable.navbar_home,"Whaddup?", "description"),
            SubCategory(R.drawable.navbar_qr,"Not much. Wbu?", "description")
        )
    }
}
