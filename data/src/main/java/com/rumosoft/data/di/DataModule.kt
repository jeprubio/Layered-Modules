package com.rumosoft.data.di

import com.rumosoft.data.SampleDataImpl
import com.rumosoft.domain.interfaces.SampleData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindData(
        sampleData: SampleDataImpl
    ): SampleData
}
