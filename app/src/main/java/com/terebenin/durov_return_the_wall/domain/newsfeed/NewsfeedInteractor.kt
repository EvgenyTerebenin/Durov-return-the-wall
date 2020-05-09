package com.terebenin.durov_return_the_wall.domain.newsfeed

import com.terebenin.durov_return_the_wall.domain.global.repositories.NewsfeedRepository

class NewsfeedInteractor(private val repository: NewsfeedRepository) {

    suspend fun getNewsFeed() = repository.getNewsfeed()


}