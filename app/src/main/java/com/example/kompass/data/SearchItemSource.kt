package com.example.kompass.data

import com.example.kompass.R
import com.example.kompass.types.Category
import com.example.kompass.types.DimensionInfo
import com.example.kompass.types.ProductItem
import com.example.kompass.types.SustainabilityInfo

class SearchItemSource {
    fun loadSearchItems(): List<ProductItem> {
        return listOf<ProductItem>(
            ProductItem("SÄBOVIK Divan Bed", Category.FURNITURE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Polyester", "Steel", "Wood"), listOf("Sweden", "Sweden", "Norway")), R.drawable.navbar_home),
            ProductItem("SKOTTERUD Mattress", Category.FURNITURE, DimensionInfo(205, 95, 60, 200, 90), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_home),
            ProductItem("LUMIÖR Pendant Light", Category.LIGHTING, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.menu_basic_materials),
            ProductItem("FÄRGFUL Throw Blanket", Category.TEXTILES, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_user),
            ProductItem("RUMTÄM Storage Box", Category.STORAGE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.menu_main_sustainability),
            ProductItem("SKRIVNA Wall Shelf", Category.FURNITURE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_qr),
            ProductItem("KÖKSTID Tableware Set", Category.KITCHEN_AND_HOUSEHOLD_APPLIANCES, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_search),
            ProductItem("EKOLN Waste bin", Category.BATHROOM_FURNITURE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.ekoln)
        )
    }
}