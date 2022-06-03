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

    fun getAllByType(type:String, onSuccess: (data: List<ProductsResponses>) -> Unit, onFailure: () -> Unit){
        api.getMakeUpByProductType(type).enqueue(object :Callback<List<ProductsResponses>>{
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

    fun getAll(onSuccess: (data: List<ProductsResponses>) -> Unit, onFailure: () -> Unit){
        api.getMakeUp().enqueue(object : Callback<List<ProductsResponses>>{
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
    fun getById(id:String,onSuccess: (data: List<ProductsResponses>) -> Unit, onFailure: () -> Unit){
        api.getMakeUpById(id+".json").enqueue(object : Callback<List<ProductsResponses>>{
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