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
    val contentsCards: List<ContentsCard>,
    val materialsDescription: String,
    val productSpecification: String,
    @DrawableRes val imageResId: Int
)
