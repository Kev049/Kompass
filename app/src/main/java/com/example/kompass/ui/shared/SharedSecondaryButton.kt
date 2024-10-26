package com.example.kompass.ui.shared

import androidx.lifecycle.ViewModel
import com.example.kompass.SecondaryButtonItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SharedSecondaryButton : ViewModel() {
    private val _recentSecondaryButton: MutableStateFlow<SecondaryButtonItem?> = MutableStateFlow(null)
    val recentSecondaryButton: StateFlow<SecondaryButtonItem?> = _recentSecondaryButton

    // Update the image
    fun setRecentSecondaryButton(secondaryButtonItem: SecondaryButtonItem?) {
        _recentSecondaryButton.value = secondaryButtonItem
    }
}