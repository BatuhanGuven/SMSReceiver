package com.example.broadcastexamplesmsreceiver

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String> = _message

    fun updateMessage(newMessage: String) {
        _message.value = newMessage
    }
}