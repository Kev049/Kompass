package com.example.kompass.types

import androidx.annotation.DrawableRes

data class CategoryData(
    //@StringRes val title: Int,
    @DrawableRes val imageResId : Int,
    val category : Category,
    val description : String
)
