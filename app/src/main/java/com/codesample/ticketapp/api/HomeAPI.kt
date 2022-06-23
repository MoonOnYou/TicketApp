package com.codesample.ticketapp.api

import com.codesample.ticketapp.model.ResponseModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface HomeAPI {
    @GET("/latest/ios/products")
    fun getDealList(): Single<Response<ResponseModel>>
}