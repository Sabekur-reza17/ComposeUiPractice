package com.sabekur2017.composeuipractice.presentation.features.dialog

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel :ViewModel(){
    var open = mutableStateOf(false)

    fun  startLoadingThread(){
        viewModelScope.launch {
            withContext(Dispatchers.Default){
                delay(3000)
            }
            closeDialog()
        }
    }

    private fun closeDialog(){
        open.value = false
    }
}