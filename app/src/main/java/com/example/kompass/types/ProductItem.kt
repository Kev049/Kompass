package com.example.kompass.types

import androidx.annotation.DrawableRes

data class ProductItem(
    val name: String,
    val articleNr: String,
    val productDescription: String,
    val price: Int,
    val category: Category,
    val dimension: DimensionInfo,
    val sustainability: SustainabilityInfo,
    @DrawableRes val imageResId: Int
)
