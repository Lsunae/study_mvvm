package com.leesunae.study_mvvm.di

import com.leesunae.study_mvvm.data.repository.FruitRepository
import com.leesunae.study_mvvm.data.repository.FruitRepositoryImpl
import com.leesunae.study_mvvm.data.source.FruitLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideFruitRepository(
        fruitLocalDataSourceImpl: FruitLocalDataSourceImpl
    ): FruitRepository {
        return FruitRepositoryImpl(fruitLocalDataSourceImpl)
    }
}