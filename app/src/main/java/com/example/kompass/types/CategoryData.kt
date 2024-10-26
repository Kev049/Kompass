package com.example.kompass.types

import androidx.annotation.DrawableRes

data class CategoryData(
    //@StringRes val title: Int,
    @DrawableRes val imageResId : Int,
    val name : String,
    val description : String
)
