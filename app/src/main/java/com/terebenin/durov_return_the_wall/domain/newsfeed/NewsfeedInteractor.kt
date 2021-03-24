package com.terebenin.durov_return_the_wall.domain.newsfeed

import com.terebenin.durov_return_the_wall.data.newsfeed.NewsfeedRepositoryImpl
import javax.inject.Inject


class NewsfeedInteractor @Inject constructor(private val repository: NewsfeedRepositoryImpl) {

    suspend fun getNewsFeed() = repository.getNewsfeed()

}