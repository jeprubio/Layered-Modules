package com.rumosoft.data

import com.rumosoft.domain.interfaces.SampleData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SampleDataImpl @Inject constructor() : SampleData {

    override fun doSomething(): Flow<Result<Unit>> {
        return flow {
            delay(5_000)
            emit(Result.success(Unit))
        }
    }
}
