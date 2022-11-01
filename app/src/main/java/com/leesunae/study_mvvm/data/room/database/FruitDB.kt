package com.leesunae.study_mvvm.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leesunae.study_mvvm.data.room.dao.FruitDao
import com.leesunae.study_mvvm.data.room.entity.FruitEntity

@Database(entities = [FruitEntity::class], version = 1)
abstract class FruitDB : RoomDatabase() {
    abstract fun fruitDao(): FruitDao


}