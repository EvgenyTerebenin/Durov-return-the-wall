package com.terebenin.durov_return_the_wall.data.datasource.server

import retrofit2.http.GET
import retrofit2.http.Query

interface VkApi {

    //TODO() удалить перед PR    https://api.vk.com/method/friends.getOnline?v=5.52&access_token=

    companion object {
        const val METHOD_PATH = "method"
    }

    @GET("$METHOD_PATH/newsfeed.get")
    fun getNewsfeed(
        @Query("v") apiVersion: String,
        @Query("access_token") accessToken: String
    ): NewsfeedResponse
}