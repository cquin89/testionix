package com.losingtimeapps.testionix.domain.boundary

import com.losingtimeapps.testionix.domain.model.DataModel
import io.reactivex.Observable

interface DataRepository {

    fun getData(rut: String): Observable<DataModel>

}