package com.tsu.makeupapps.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MakeUpInterface {
    @GET("./v1/products.json?brand=")
    fun getMakeUpByBrand(@Query("brand")brand:String): Call<List<ProductsResponses>>

    @GET("./v1/products.json?product_type=")
    fun getMakeUpByProductType(@Query("product_type")product_type:String): Call<List<ProductsResponses>>

    @GET("./v1/products/{id}")
    fun getMakeUpById(@Path("id") id: String): Call<List<ProductsResponses>>
}