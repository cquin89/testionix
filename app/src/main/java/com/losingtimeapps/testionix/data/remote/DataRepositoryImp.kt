package com.losingtimeapps.testionix.data.remote

import com.losingtimeapps.testionix.domain.boundary.DataRepository
import com.losingtimeapps.testionix.domain.model.DataModel
import io.reactivex.Observable

open class DataRepositoryImp(
    private val dataService: DataService
) : DataRepository {

    override fun getData(rut: String): Observable<DataModel> {
        return dataService.getData(rut)
    }

}