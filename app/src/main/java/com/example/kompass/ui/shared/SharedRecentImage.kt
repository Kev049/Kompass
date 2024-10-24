package com.example.kompass.ui.shared

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SharedRecentImage : ViewModel() {
    private val _recentImage: MutableStateFlow<Int?> = MutableStateFlow(null)
    val recentImage: StateFlow<Int?> = _recentImage

    // Update the image
    fun setRecentImage(imageId: Int?) {
        _recentImage.value = imageId
    }

}