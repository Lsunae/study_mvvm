package com.leesunae.study_mvvm.data.source

import com.leesunae.study_mvvm.data.repository.Callback
import com.leesunae.study_mvvm.data.room.entity.FruitEntity

interface FruitLocalDataSource {
    fun createFruit(fruitName: String, callback: Callback<Boolean>)

    fun getFruit(fruitName: String, callback: Callback<FruitEntity>)
}