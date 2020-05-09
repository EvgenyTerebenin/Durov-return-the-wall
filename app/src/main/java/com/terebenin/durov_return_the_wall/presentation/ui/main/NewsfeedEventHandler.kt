package com.terebenin.durov_return_the_wall.presentation.ui.main

import com.terebenin.durov_return_the_wall.data.models.newsfeedResponse.ItemsItem

interface NewsfeedEventHandler {
    fun onClickNewsfeedItem(item: ItemsItem)
}