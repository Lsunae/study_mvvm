package com.leesunae.study_mvvm.data.source

import com.leesunae.bebehelper_mvp.util.AppExecutors
import com.leesunae.study_mvvm.data.repository.Callback
import com.leesunae.study_mvvm.data.room.database.FruitDB
import com.leesunae.study_mvvm.data.room.entity.FruitEntity
import javax.inject.Inject

class FruitLocalDataSourceImpl @Inject constructor(private val fruitDB: FruitDB) :
    FruitLocalDataSource {
    private val appExecutors: AppExecutors = AppExecutors()

    override fun createFruit(fruitName: String, callback: Callback<Boolean>) {
        appExecutors.diskIO.execute {
            val newFruit = FruitEntity(
                fruitName = fruitName
            )
            val insertedPk = fruitDB.fruitDao().insertFruit(newFruit)
            if (insertedPk != null) {
                appExecutors.mainThread.execute {
                    callback.onSuccess(true)
                }
            }
        }
    }

    override fun getFruit(fruitName: String, callback: Callback<FruitEntity>) {
        appExecutors.diskIO.execute {
            val fruit = fruitDB.fruitDao().getFruit(fruitName)
            appExecutors.mainThread.execute {
                if (fruit != null) callback.onSuccess(fruit)
                else callback.onFailure("The fruit does not exist.")
            }
        }
    }
}