package com.terebenin.durov_return_the_wall.data.datasource.network

import com.terebenin.durov_return_the_wall.data.newsfeed.response.NewsfeedResponse
import retrofit2.Response
import retrofit2.http.GET

interface VkApi {

    companion object {
        const val METHOD_PATH = "method"
    }

    @GET("$METHOD_PATH/newsfeed.get")
    suspend fun getNewsfeed(): Response<NewsfeedResponse>
}