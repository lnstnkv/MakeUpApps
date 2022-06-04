package com.tsu.makeupapps

data class Brands (
    val id:String,
    val name: String,
    val image: Int,
)

data class KindProduct (
    val id:String,
    val name: String,
    val brand: String,
    val image: Int,
)