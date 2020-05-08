package com.terebenin.durov_return_the_wall.data.repositories

import com.terebenin.durov_return_the_wall.data.datasource.server.VkApi
import com.terebenin.durov_return_the_wall.data.models.newsfeedResponse.NewsfeedResponse
import com.terebenin.durov_return_the_wall.domain.global.repositories.NewsfeedRepository

class NewsfeedRepositoryImpl(val vkApi: VkApi) : NewsfeedRepository {

    override fun getNewsfeed(): NewsfeedResponse {
//  TODO  vkApi.getNewsfeed()
    }
}