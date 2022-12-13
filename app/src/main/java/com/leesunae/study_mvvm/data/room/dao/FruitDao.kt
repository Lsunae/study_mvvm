package com.leesunae.study_mvvm.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leesunae.study_mvvm.data.room.entity.FruitEntity

@Dao
interface FruitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFruit(fruit: FruitEntity): Long

    @Query("SELECT * FROM fruit WHERE fruitName = :name")
    fun getFruit(name: String): FruitEntity?
}