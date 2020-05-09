package com.terebenin.durov_return_the_wall.data.datasource.network

import com.terebenin.durov_return_the_wall.data.models.newsfeedResponse.NewsfeedResponse
import retrofit2.Response
import retrofit2.http.GET

interface VkApi {

    //TODO() удалить перед PR    https://api.vk.com/method/friends.getOnline?v=5.52&access_token=

    companion object {
        const val METHOD_PATH = "method"
    }

    @GET("$METHOD_PATH/newsfeed.get")
    suspend fun getNewsfeed(): Response<NewsfeedResponse>
}