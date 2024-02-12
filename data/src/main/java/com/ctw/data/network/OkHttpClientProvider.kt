package com.ctw.data.network

import okhttp3.OkHttpClient

object OkHttpClientProvider {
    fun getOkHttpClient() = OkHttpClient.Builder()
//        .connectTimeout(30, TimeUnit.SECONDS)
//        .readTimeout(30, TimeUnit.SECONDS)
//        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}