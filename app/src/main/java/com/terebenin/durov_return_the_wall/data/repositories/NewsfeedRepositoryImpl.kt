package com.terebenin.durov_return_the_wall.data.repositories

import com.terebenin.durov_return_the_wall.data.datasource.network.BaseRepository
import com.terebenin.durov_return_the_wall.data.datasource.network.VkApi
import com.terebenin.durov_return_the_wall.data.models.newsfeedResponse.NewsfeedResponse
import com.terebenin.durov_return_the_wall.domain.global.repositories.NewsfeedRepository

class NewsfeedRepositoryImpl(private val vkApi: VkApi) : NewsfeedRepository, BaseRepository() {

    override suspend fun getNewsfeed(): NewsfeedResponse? {
        return safeApiCall(
            call = { vkApi.getNewsfeed() },
            errorMessage = "Error fetching newsfeed"
        )
    }
}
