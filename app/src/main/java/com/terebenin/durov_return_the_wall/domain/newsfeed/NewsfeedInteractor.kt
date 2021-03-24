package com.terebenin.durov_return_the_wall.domain.newsfeed


class NewsfeedInteractor(private val repository: NewsfeedRepository) {
    suspend fun getNewsFeed() = repository.getNewsfeed()

}