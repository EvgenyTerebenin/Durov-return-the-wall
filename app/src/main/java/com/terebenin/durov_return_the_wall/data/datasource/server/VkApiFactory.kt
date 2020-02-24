package com.terebenin.durov_return_the_wall.data.datasource.server

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.terebenin.durov_return_the_wall.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object VkApiFactory {

    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
//FIXME      .addQueryParameter("access_token", "здесь должен быть токен")
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private fun initOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder().apply {
            addInterceptor(authInterceptor)
            if (BuildConfig.DEBUG) {
                val logInterceptor = HttpLoggingInterceptor()
                logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                addInterceptor(logInterceptor)
            }
        }
        return okHttpClientBuilder.build()
    }

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(initOkHttpClient())
        .baseUrl(BuildConfig.BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val vkApi: VkApi = retrofit().create(VkApi::class.java)

}