package com.terebenin.durov_return_the_wall.domain.newsfeed

import com.terebenin.durov_return_the_wall.data.datasource.network.VkApiFactory
import com.terebenin.durov_return_the_wall.data.newsfeed.NewsfeedRepositoryImpl

class NewsfeedInteractor {
    private val repository = NewsfeedRepositoryImpl(VkApiFactory.vkApi)

    suspend fun getNewsFeed() = repository.getNewsfeed()

}