package com.leesunae.study_mvvm.data.source

import com.leesunae.study_mvvm.data.repository.Callback
import com.leesunae.study_mvvm.data.room.entity.FruitEntity

class FruitLocalDataSourceImpl : FruitLocalDataSource {
    override fun createFruit(text: String, callback: Callback<Boolean>) {

    }

    override fun getFruit(email: String, callback: Callback<FruitEntity>) {

    }
}