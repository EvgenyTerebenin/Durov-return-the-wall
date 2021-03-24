package com.terebenin.durov_return_the_wall.presentation.newsfeed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.NewsfeedResponseDomainModel
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.PostItemDomainModel
import com.terebenin.durov_return_the_wall.presentation.global.SingleLiveEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException

class NewsfeedViewModel(private val interactor: NewsfeedInteractor) :
    ViewModel(),
    NewsfeedEventHandler {
    val itemClickEvent =
        SingleLiveEvent<Int>()
    val eventHttpException =
        SingleLiveEvent<HttpException>()

    val newsfeedResponse = MutableLiveData<NewsfeedResponseDomainModel>()
    val isLoading = MutableLiveData<Boolean>()
    private var job: Job? = null

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
                    newsfeedResponse.value = it
                    isLoading.value = false
                }
            } catch (e: Exception) {
                if (e is HttpException) {
                    eventHttpException.value = e
                } else e.printStackTrace()
            }
        }
    }

    override fun onClickNewsfeedItem(item: PostItemDomainModel) {
        itemClickEvent.value = item.postId
    }

}
