package com.leesunae.study_mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FruitViewModel() : ViewModel() {
    private val _fruit = MutableLiveData<String>()
    val fruit: LiveData<String> = _fruit

    fun setFruit(textStr: String) {
        _fruit.value = textStr
    }
}