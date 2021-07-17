package com.juni.roverphotos

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


interface RoverApiServices {
    @GET("photos?sol=1000&page=1&api_key=93k8HC0mO7agDECeHh6ghlSTbR6nbgwcCsUobshS\n")
    suspend fun getRoverPhotos(): String
}


var retrofit = Retrofit.Builder()
    .baseUrl("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/")
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

var service: RoverApiServices = retrofit.create(RoverApiServices::class.java)