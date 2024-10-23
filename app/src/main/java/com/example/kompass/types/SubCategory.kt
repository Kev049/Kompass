package com.example.kompass.types

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SubCategory(
    //@StringRes val title: Int,
    @DrawableRes val imageResId : Int,
    val description : String
)
