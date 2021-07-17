package com.juni.roverphotos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import org.json.JSONObject

class MainViewModel:ViewModel() {


    private val _roverList=MutableLiveData<MutableList<Photos>>()
    val roverList:LiveData<MutableList<Photos>>
    get()=_roverList

    init {
        viewModelScope.launch {

            _roverList.value=fetchPhotos()

        }
    }

    private suspend fun fetchPhotos() :MutableList<Photos>{

        return withContext(Dispatchers.IO){

            val roverListString= service.getRoverPhotos()

            val roverList=  parsePhotosResult(roverListString)

           // Log.d("Hola",roverList)

            roverList


        }

    }

    private fun parsePhotosResult(roverList: String):MutableList<Photos> {

        val photosJsonObject=JSONObject(roverList)
        val photosJsonArray=photosJsonObject.getJSONArray("photos")
        val roverList= mutableListOf<Photos>()

        for (i in 0 until photosJsonArray.length()){

            val photosJsonObjectSon=photosJsonArray[i] as JSONObject

            val id=photosJsonObjectSon.getString("id")

            val earthDate=photosJsonObjectSon.getString("earth_date")

            val camera=photosJsonObjectSon.getJSONObject("camera")

            val nameCamera=camera.getString("full_name")

            val img_src=photosJsonObjectSon.getString("img_src")

            val photos=Photos(id,earthDate,nameCamera,img_src)

            roverList.add(photos)
        }

        return roverList


    }


}