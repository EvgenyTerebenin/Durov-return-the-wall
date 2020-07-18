package com.terebenin.durov_return_the_wall.domain.newsfeed

import com.terebenin.durov_return_the_wall.data.newsfeed.response.NewsfeedResponse

interface NewsfeedRepository {
    suspend fun getNewsfeed(): NewsfeedResponse?
}