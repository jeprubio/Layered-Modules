package com.rumosoft.domain.interfaces

import kotlinx.coroutines.flow.Flow

interface SampleData {
    fun doSomething(): Flow<Result<Unit>>
}
