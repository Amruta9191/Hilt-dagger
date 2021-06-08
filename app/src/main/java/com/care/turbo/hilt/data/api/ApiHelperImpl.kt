package com.care.turbo.hilt.data.api

import com.care.turbo.hilt.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService):ApiHelper {
    override suspend fun getusers(): Response<List<User>> {
        return apiService.getUsers()
    }


}