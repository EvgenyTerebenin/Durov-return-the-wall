package com.terebenin.durov_return_the_wall.domain.newsfeed

import com.terebenin.durov_return_the_wall.domain.newsfeed.model.NewsfeedResponseDomainModel

interface NewsfeedRepository {
    suspend fun getNewsfeed(): NewsfeedResponseDomainModel?
}