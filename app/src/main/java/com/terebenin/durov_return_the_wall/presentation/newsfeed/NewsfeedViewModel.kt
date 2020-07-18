package com.terebenin.durov_return_the_wall.presentation.newsfeed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terebenin.durov_return_the_wall.data.newsfeed.response.ItemsItem
import com.terebenin.durov_return_the_wall.data.newsfeed.response.NewsfeedResponse
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor
import com.terebenin.durov_return_the_wall.presentation.global.SingleLiveEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException

class NewsfeedViewModel : ViewModel(),
    NewsfeedEventHandler {
    private val interactor = NewsfeedInteractor()
    val itemClickEvent =
        SingleLiveEvent<Int>()
    val eventHttpException =
        SingleLiveEvent<HttpException>()
    val newsfeed = MutableLiveData<NewsfeedResponse>()
    val isLoading = MutableLiveData<Boolean>()
    var job: Job? = null

    init {
        getNewsfeed()
    }


    fun getNewsfeed() {
        job?.cancel()
        job = viewModelScope.launch {
            try {
                isLoading.value = true
                val result = interactor.getNewsFeed()
                result?.let {
                    newsfeed.value = it
                    isLoading.value = false
                }
            } catch (e: Exception) {
                if (e is HttpException) {
                    eventHttpException.value = e
                }
            }
        }
    }

    override fun onClickNewsfeedItem(item: ItemsItem) {
        itemClickEvent.value = item.postId
    }

}
