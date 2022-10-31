package com.leesunae.study_mvvm.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leesunae.study_mvvm.data.room.entity.FruitEntity

@Dao
interface FruitDao {

    /** 과일 추가 */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFruit(fruit: FruitEntity): Long

    /** 과일 조회 */
    @Query("SELECT * FROM fruit WHERE id = :id")
    fun getFruit(id: Int): FruitEntity
}