package com.losingtimeapps.testionix.domain.usecase

import com.losingtimeapps.testionix.domain.boundary.BaseScheduler
import com.losingtimeapps.testionix.domain.boundary.DataRepository
import com.losingtimeapps.testionix.domain.model.DataModel
import io.reactivex.Observable


class GetDataUseCase(
    val dataRepository: DataRepository,
    val baseScheduler: BaseScheduler
) : UseCase(baseScheduler) {

    fun invoke(rut: String): Observable<DataModel> {

        return dataRepository.getData(rut)
            .subscribeOn(baseScheduler.io())
            .observeOn(baseScheduler.ui())
    }
}