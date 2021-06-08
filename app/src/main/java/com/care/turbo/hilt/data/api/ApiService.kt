package com.care.turbo.hilt.data.api

import com.care.turbo.hilt.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers():Response<List<User>>
}