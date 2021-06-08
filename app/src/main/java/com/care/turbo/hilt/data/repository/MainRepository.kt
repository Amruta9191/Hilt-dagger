package com.care.turbo.hilt.data.repository

import com.care.turbo.hilt.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getusers()
}