package com.leesunae.study_mvvm.data.repository

import com.leesunae.study_mvvm.data.room.entity.FruitEntity

interface FruitRepository {
    fun createFruit(
        fruitName: String,
        callback: Callback<Boolean>
    )

    fun getFruit(id: Int, callback: Callback<FruitEntity>)
}