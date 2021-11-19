package com.rumosoft.domain

import com.rumosoft.domain.interfaces.SampleData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SampleUseCaseImpl @Inject constructor(
    private val sampleData: SampleData,
) : SampleUseCase {

    override operator fun invoke(): Flow<Result<Unit>> =
        sampleData.doSomething()
}
