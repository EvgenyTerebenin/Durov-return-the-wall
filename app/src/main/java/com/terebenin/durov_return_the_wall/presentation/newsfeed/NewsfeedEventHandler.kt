package com.terebenin.durov_return_the_wall.presentation.newsfeed

import com.terebenin.durov_return_the_wall.data.newsfeed.response.Item

interface NewsfeedEventHandler {
    fun onClickNewsfeedItem(item: Item)
}