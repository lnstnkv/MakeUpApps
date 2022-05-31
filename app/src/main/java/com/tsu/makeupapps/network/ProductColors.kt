package com.tsu.makeupapps.network

import kotlinx.serialization.Serializable

@Serializable
data class ProductColors(
    val hex_value:String? = null,
    val colour_name:String? = null
)
