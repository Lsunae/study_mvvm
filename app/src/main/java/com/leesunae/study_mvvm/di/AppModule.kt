package com.leesunae.study_mvvm.di

import androidx.room.Room
import com.leesunae.study_mvvm.data.repository.FruitRepository
import com.leesunae.study_mvvm.data.repository.FruitRepositoryImpl
import com.leesunae.study_mvvm.data.room.database.FruitDB
import com.leesunae.study_mvvm.viewModel.FruitViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<FruitRepository> { FruitRepositoryImpl() }
    viewModel { FruitViewModel(get()) }

    single {
        Room.databaseBuilder(
            get(),
            FruitDB::class.java, "fruit"
        )
            .fallbackToDestructiveMigration()
            .build()


    }
}