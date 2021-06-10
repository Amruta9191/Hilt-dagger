package com.care.turbo.hilt.di
import com.care.turbo.hilt.BuildConfig

import com.care.turbo.hilt.data.api.ApiHelper
import com.care.turbo.hilt.data.api.ApiHelperImpl
import com.care.turbo.hilt.data.api.ApiService
import com.care.turbo.hilt.data.repository.MainRepository
import com.care.turbo.hilt.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }
    else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,baseUrl:String):Retrofit =
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl).client(okHttpClient).build()

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl):ApiHelper = apiHelper

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ApiService =retrofit.create(ApiService::class.java)



}