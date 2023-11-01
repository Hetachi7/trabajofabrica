package com.example.pruebadeiby

import com.google.gson.annotations.SerializedName

data class perros(@SerializedName("status") var status:String, @SerializedName("message") var images: List<String>)
