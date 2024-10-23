package com.example.kompass.types

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SubCategory(
    @StringRes val StringResourceId: Int,
    @DrawableRes val imageResourceId : Int
)
