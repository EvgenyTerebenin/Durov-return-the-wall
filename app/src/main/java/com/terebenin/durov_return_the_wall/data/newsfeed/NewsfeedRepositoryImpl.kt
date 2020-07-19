package com.terebenin.durov_return_the_wall.data.newsfeed

import com.terebenin.durov_return_the_wall.data.datasource.network.VkApi
import com.terebenin.durov_return_the_wall.data.newsfeed.response.toDomainModel
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedRepository
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.NewsfeedResponseDomainModel

class NewsfeedRepositoryImpl(private val vkApi: VkApi) : NewsfeedRepository {
    override suspend fun getNewsfeed(): NewsfeedResponseDomainModel? {
        return vkApi.getNewsfeed().body()?.response?.toDomainModel()
    }
}
