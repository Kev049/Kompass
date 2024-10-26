package com.example.kompass.types

import androidx.annotation.DrawableRes

data class ProductItem(
    val name: String,
    val category: Category,
    val dimension: DimensionInfo,
    val sustainability: SustainabilityInfo,
    @DrawableRes val imageResId: Int
)
