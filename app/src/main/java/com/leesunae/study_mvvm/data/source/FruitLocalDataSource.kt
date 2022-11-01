package com.leesunae.study_mvvm.data.source

import com.leesunae.study_mvvm.data.repository.Callback
import com.leesunae.study_mvvm.data.room.entity.FruitEntity

interface FruitLocalDataSource {
    fun createFruit(
        text: String,
        callback: Callback<Boolean>
    )

    fun getFruit(email: String, callback: Callback<FruitEntity>)
}