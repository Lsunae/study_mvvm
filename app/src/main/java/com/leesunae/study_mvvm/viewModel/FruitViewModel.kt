package com.leesunae.study_mvvm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leesunae.study_mvvm.data.repository.Callback
import com.leesunae.study_mvvm.data.repository.FruitRepository
import com.leesunae.study_mvvm.data.room.entity.FruitEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FruitViewModel @Inject constructor(private val repository: FruitRepository) : ViewModel() {
    private val _registeredFruit = MutableLiveData<String>()
    private val _searchFruit = MutableLiveData<String>()
    val registeredFruit: LiveData<String> = _registeredFruit
    val searchFruit: LiveData<String> = _searchFruit

    fun registerFruit(fruitName: String) {
        repository.createFruit(fruitName, object : Callback<Boolean> {
            override fun onSuccess(response: Boolean) {
                Log.i("[${javaClass.name}]", "$response")
                _registeredFruit.value = fruitName
            }

            override fun onFailure(message: String) {
                Log.i("[${javaClass.name}]", message)
            }
        })
    }

    fun searchFruit(fruitName: String) {
        repository.getFruit(fruitName, object : Callback<FruitEntity> {
            override fun onSuccess(response: FruitEntity) {
                Log.i("[${javaClass.name}]", "$response")
                if (response.id != 0 && !response.fruitName.isNullOrEmpty())
                    _searchFruit.value = response.fruitName!!
            }

            override fun onFailure(message: String) {
                Log.i("[${javaClass.name}]", message)
            }
        })
    }
}