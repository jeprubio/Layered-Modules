package com.rumosoft.presentation.di

import com.rumosoft.domain.SampleUseCase
import com.rumosoft.domain.SampleUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCasesModule {
    @Binds
    @Singleton
    abstract fun bindUseCase(
        useCase: SampleUseCaseImpl
    ): SampleUseCase
}
