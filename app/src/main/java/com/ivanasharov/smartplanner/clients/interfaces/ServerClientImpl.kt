package com.ivanasharov.smartplanner.clients.interfaces

import com.google.gson.GsonBuilder
import com.ivanasharov.smartplanner.data.server_dto.ServerWeather
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServerClientImpl @Inject constructor(): ServerClient {

    private val mService: ApiDefinition
    companion object{
        private const val BASE_URL = "http://api.openweathermap.org/"
    }

    init {
        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
        mService = retrofit.create(ApiDefinition::class.java)
    }

    override suspend fun getCurrentWeather(lat: Double, lon: Double, language: String): ServerWeather {
        return mService.loadDataOfWeather(lat, lon, language).await()
        //return mService.loadDataOfWeather(56.32867, 44.00205, language).await()
    }

}