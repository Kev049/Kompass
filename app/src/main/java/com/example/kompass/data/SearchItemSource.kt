package com.example.kompass.data

import com.example.kompass.R
import com.example.kompass.types.Category
import com.example.kompass.types.DimensionInfo
import com.example.kompass.types.ProductItem
import com.example.kompass.types.SustainabilityInfo

class SearchItemSource {
    fun loadSearchItems(): List<ProductItem> {
        return listOf<ProductItem>(
            ProductItem("SÄBOVIK", "693.857.50", "Divan Bed", 3795, Category.BEDS_AND_MATTRESSES, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(5, listOf("Polyester", "Steel", "Wood"), listOf("Sweden", "Sweden", "Norway")), R.drawable.sabovik),
            ProductItem("SKOTTERUD", "203.073.20", "Mattress", 2595,Category.BEDS_AND_MATTRESSES, DimensionInfo(205, 95, 60, 200, 90), SustainabilityInfo(15, listOf("Cotton", "Polyester", "Steel"), listOf("Spain", "Sweden", "Norway")), R.drawable.skotterud),
            ProductItem("Malm", "591.759.55", "Bed Frame", 2395, Category.BEDS_AND_MATTRESSES, DimensionInfo(209, 156, 100, 200, 140), SustainabilityInfo(7, listOf("Foil", "Galvanized Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.malm),
            ProductItem("Slattum", "405.712.48", "Bed Frame", 1495, Category.BEDS_AND_MATTRESSES, DimensionInfo(206, 164, 85, 200, 160), SustainabilityInfo(12, listOf("Foil", "Polyester", "Wood"), listOf("Denmark", "Germany", "Norway")), R.drawable.slattum),


        )
    }
}

/*
            ProductItem("LUMIÖR", "203.073.20", "Pendant Light", 2595,Category.LIGHTING, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.menu_basic_materials),
            ProductItem("FÄRGFUL","203.073.20", "Throw Blanket", 2595, Category.TEXTILES, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_user),
            ProductItem("RUMTÄM", "203.073.20", "Storage Box", 2595, Category.STORAGE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.menu_main_sustainability),
            ProductItem("SKRIVNA", "203.073.20", "Wall Shelf", 2595,Category.FURNITURE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_qr),
            ProductItem("KÖKSTID", "203.073.20", "Tableware Set", 2595,Category.KITCHENWARE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_search)
 */