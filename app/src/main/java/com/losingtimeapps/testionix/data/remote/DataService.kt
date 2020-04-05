package com.losingtimeapps.testionix.data.remote


import com.losingtimeapps.testionix.domain.model.DataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface DataService {

    @GET("test-tecnico/search")
    fun getData(@Query("rut") rut :String
    ): Observable<DataModel>



}