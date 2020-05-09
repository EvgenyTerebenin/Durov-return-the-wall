package com.terebenin.durov_return_the_wall.presentation.mvvm.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terebenin.durov_return_the_wall.data.models.newsfeedResponse.ItemsItem
import com.terebenin.durov_return_the_wall.data.models.newsfeedResponse.NewsfeedResponse
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor
import com.terebenin.durov_return_the_wall.presentation.ui.main.NewsfeedEventHandler
import kotlinx.coroutines.launch

class NewsfeedViewModel(interactor: NewsfeedInteractor) : ViewModel(), NewsfeedEventHandler {
    val itemClickEvent = MutableLiveData<Int>()
    val newsfeed = MutableLiveData<NewsfeedResponse>()

    init {
        viewModelScope.launch {
            val result = interactor.getNewsFeed()
            result?.let {
                newsfeed.value = it
            }
        }
    }

    override fun onClickNewsfeedItem(item: ItemsItem) {
        itemClickEvent.value = item.postId
    }

}
