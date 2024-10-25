package com.example.kompass.types

import androidx.annotation.DrawableRes

data class SearchItemInfo(
    val name: String,
    val category: String,
    @DrawableRes val imageResId: Int
)
