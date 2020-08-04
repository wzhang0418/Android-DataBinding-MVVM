package com.apolis.b26mvvmtut.api

import com.apolis.b26mvvmtut.model.GithubRepository
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {
    private const val BASE_URL = "https://ghapi.huchen.dev/"

    private val _endpoint: EndPoint by lazy {
        //retrofit client that is used to call the network call
        val client = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        client.create(EndPoint::class.java)
    }

    fun getApiEndPoint(): EndPoint = _endpoint
}

interface EndPoint {
    @GET("repositories?language=&since=daily&spoken_language_code=")
    fun getRepositories(): Call<List<GithubRepository>>
}