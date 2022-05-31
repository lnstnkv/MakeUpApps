package com.tsu.makeupapps.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Controller {
    private val api: MakeUpInterface = Network.retrofit.create(MakeUpInterface::class.java)
    fun getByBrand(brand: String, onSuccess: (data: List<ProductsResponses>) -> Unit, onFailure: () -> Unit){
        api.getMakeUpByBrand(brand).enqueue(object : Callback<List<ProductsResponses>>{
            override fun onResponse(
                call: Call<List<ProductsResponses>>,
                response: Response<List<ProductsResponses>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess.invoke(it)
                    }
                } else {
                    onFailure.invoke()
                }
            }

            override fun onFailure(call: Call<List<ProductsResponses>>, t: Throwable) {
                t.printStackTrace()
                onFailure.invoke()
            }
        })
    }

}