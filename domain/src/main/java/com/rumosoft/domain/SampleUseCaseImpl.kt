package com.rumosoft.domain

import com.rumosoft.domain.interfaces.SampleData
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class SampleUseCaseImpl @Inject constructor(
    private val sampleData: SampleData,
) : SampleUseCase {

    override operator fun invoke(): Flow<Result<Unit>> =
        sampleData.doSomething()
}
