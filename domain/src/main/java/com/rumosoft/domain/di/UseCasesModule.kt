package com.rumosoft.domain.di

import com.rumosoft.domain.SampleUseCase
import com.rumosoft.domain.SampleUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCasesModule {
    @Binds
    abstract fun bindUseCase(
        useCase: SampleUseCaseImpl
    ): SampleUseCase
}
