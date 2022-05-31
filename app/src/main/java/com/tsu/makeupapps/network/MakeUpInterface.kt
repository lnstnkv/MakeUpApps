package com.tsu.makeupapps.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MakeUpInterface {
    @GET("./v1/products.json?brand=")
    fun getMakeUpByBrand(@Query("brand")brand:String): Call<List<ProductsResponses>>
}