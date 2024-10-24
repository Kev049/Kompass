package com.example.kompass.data

import com.example.kompass.types.SearchItemInfo
import com.example.kompass.R

class SearchItemSource {
    fun loadSearchItems(): List<SearchItemInfo> {
        return listOf<SearchItemInfo>(
            SearchItemInfo("SÖMNA Desk", "Furniture", R.drawable.navbar_home),
            SearchItemInfo("LUMIÖR Pendant Light", "Lighting", R.drawable.menu_basic_materials),
            SearchItemInfo("FÄRGFUL Throw Blanket", "Textiles", R.drawable.navbar_user),
            SearchItemInfo("RUMTÄM Storage Box", "Storage", R.drawable.menu_main_sustainability),
            SearchItemInfo("SKRIVNA Wall Shelf", "Furniture", R.drawable.navbar_qr),
            SearchItemInfo("KÖKSTID Tableware Set", "Kitchen", R.drawable.navbar_search)
        )
    }
}