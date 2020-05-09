package com.terebenin.durov_return_the_wall.domain.global.repositories

import com.terebenin.durov_return_the_wall.data.models.newsfeedResponse.NewsfeedResponse

interface NewsfeedRepository {
    suspend fun getNewsfeed(): NewsfeedResponse?
}