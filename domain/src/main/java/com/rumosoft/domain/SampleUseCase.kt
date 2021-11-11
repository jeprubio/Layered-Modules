package com.rumosoft.domain

import kotlinx.coroutines.flow.Flow

interface SampleUseCase {

    operator fun invoke(): Flow<Result<Unit>>
}
