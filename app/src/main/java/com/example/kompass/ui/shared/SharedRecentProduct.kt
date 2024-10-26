package com.example.kompass.ui.shared

import androidx.lifecycle.ViewModel
import com.example.kompass.types.ProductItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SharedRecentProduct : ViewModel() {
    private val _recentProduct: MutableStateFlow<ProductItem?> = MutableStateFlow(null)
    val recentProduct: StateFlow<ProductItem?> = _recentProduct

    // Update the image
    fun setRecentProduct(productItem: ProductItem?) {
        _recentProduct.value = productItem
    }
}