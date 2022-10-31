package com.leesunae.study_mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FruitViewModel() : ViewModel() {
    private val _registeredFruit = MutableLiveData<String>()
    val registeredFruit: LiveData<String> = _registeredFruit

    fun getFruit(textStr: String) {
        _registeredFruit.value = textStr
    }

}