package com.terebenin.durov_return_the_wall.data.newsfeed

import com.terebenin.durov_return_the_wall.data.global.BaseRepository
import com.terebenin.durov_return_the_wall.data.datasource.network.VkApi
import com.terebenin.durov_return_the_wall.data.newsfeed.response.NewsfeedResponse
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedRepository

class NewsfeedRepositoryImpl(private val vkApi: VkApi) : NewsfeedRepository, BaseRepository() {

    override suspend fun getNewsfeed(): NewsfeedResponse? {
        return safeApiCall(
            call = { vkApi.getNewsfeed() },
            errorMessage = "Error fetching newsfeed"
        )
    }
}
