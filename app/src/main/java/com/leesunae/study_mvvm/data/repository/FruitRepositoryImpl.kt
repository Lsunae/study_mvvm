package com.leesunae.study_mvvm.data.repository

import com.leesunae.study_mvvm.data.room.entity.FruitEntity
import com.leesunae.study_mvvm.data.source.FruitLocalDataSource
import javax.inject.Inject

class FruitRepositoryImpl @Inject constructor(private val localDataSource: FruitLocalDataSource) :
    FruitRepository {
    override fun createFruit(fruitName: String, callback: Callback<Boolean>) {
        localDataSource.createFruit(fruitName, callback)
    }

    override fun getFruit(fruitName: String, callback: Callback<FruitEntity>) {
        localDataSource.getFruit(fruitName, callback)
    }
}