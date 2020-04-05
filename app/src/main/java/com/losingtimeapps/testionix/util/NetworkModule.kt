package com.losingtimeapps.testionix.util

import com.google.gson.Gson
import com.losingtimeapps.testionix.data.remote.DataService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


internal class NetworkModule {

    companion object {
        fun provideService(): DataService =
            provideRetrofitInstance().create(DataService::class.java)

        private fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
            .baseUrl("https://sandbox.ionix.cl")
            .client(OkHttpClient().newBuilder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

    }
}