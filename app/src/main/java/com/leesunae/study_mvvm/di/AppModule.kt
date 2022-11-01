package com.leesunae.study_mvvm.di

import com.leesunae.study_mvvm.data.repository.FruitRepository
import com.leesunae.study_mvvm.data.repository.FruitRepositoryImpl
import com.leesunae.study_mvvm.viewModel.FruitViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<FruitRepository> { FruitRepositoryImpl() }
    viewModel { FruitViewModel(get()) }
}