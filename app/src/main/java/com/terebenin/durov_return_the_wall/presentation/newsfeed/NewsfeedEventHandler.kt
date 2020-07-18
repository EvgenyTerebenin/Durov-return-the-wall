package com.terebenin.durov_return_the_wall.presentation.newsfeed

import com.terebenin.durov_return_the_wall.domain.newsfeed.model.PostItemDomainModel

interface NewsfeedEventHandler {
    fun onClickNewsfeedItem(item: PostItemDomainModel)
}