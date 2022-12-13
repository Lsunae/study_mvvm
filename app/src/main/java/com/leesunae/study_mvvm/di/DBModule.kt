package com.leesunae.study_mvvm.di

import android.content.Context
import androidx.room.Room
import com.leesunae.study_mvvm.data.room.dao.FruitDao
import com.leesunae.study_mvvm.data.room.database.FruitDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {
    @Singleton
    @Provides
    fun provideFruitDatabase(@ApplicationContext context: Context): FruitDB {
        return Room
            .databaseBuilder(
                context,
                FruitDB::class.java,
                "FruitDB"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideFruitDao(fruitDB: FruitDB): FruitDao {
        return fruitDB.fruitDao()
    }
}