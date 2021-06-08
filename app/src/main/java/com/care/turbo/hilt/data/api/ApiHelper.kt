package com.care.turbo.hilt.data.api

import com.care.turbo.hilt.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getusers():Response<List<User>>
}