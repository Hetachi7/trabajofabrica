package com.example.pruebadeiby

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Apiservi {
        @GET fun getCharacterByName(@Url url:String): Call<perros>
    }