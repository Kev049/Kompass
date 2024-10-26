package com.example.kompass.data

import com.example.kompass.types.ProductItem
import com.example.kompass.R
import com.example.kompass.types.DimensionInfo
import com.example.kompass.types.SustainabilityInfo

class SearchItemSource {
    fun loadSearchItems(): List<ProductItem> {
        return listOf<ProductItem>(
            ProductItem("SÄBOVIK", "693.857.50", "Divan Bed", 3795, "Furniture", DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(1000, listOf("Polyester", "Steel", "Wood"), listOf("Sweden", "Sweden", "Norway")), R.drawable.sabovik),
            ProductItem("SKOTTERUD", "203.073.20", "Mattress", 2595,"Furniture", DimensionInfo(205, 95, 60, 200, 90), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_home),
            ProductItem("LUMIÖR", "203.073.20", "Pendant Light", 2595,"Lighting", DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.menu_basic_materials),
            ProductItem("FÄRGFUL","203.073.20", "Throw Blanket", 2595, "Textiles", DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_user),
            ProductItem("RUMTÄM", "203.073.20", "Storage Box", 2595, "Storage", DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.menu_main_sustainability),
            ProductItem("SKRIVNA", "203.073.20", "Wall Shelf", 2595,"Furniture", DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_qr),
            ProductItem("KÖKSTID", "203.073.20", "Tableware Set", 2595,"Kitchen", DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_search)
        )
    }
}