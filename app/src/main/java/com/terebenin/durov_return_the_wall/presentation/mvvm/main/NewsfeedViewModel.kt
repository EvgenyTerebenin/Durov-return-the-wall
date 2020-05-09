package com.terebenin.durov_return_the_wall.presentation.mvvm.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terebenin.durov_return_the_wall.data.models.newsfeedResponse.NewsfeedResponse
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor
import kotlinx.coroutines.launch

class NewsfeedViewModel(interactor: NewsfeedInteractor) : ViewModel() {

    val newsfeed = MutableLiveData<NewsfeedResponse>()

    init {
        viewModelScope.launch {
            val result = interactor.getNewsFeed()
            result?.let {
                newsfeed.value = it
            }
        }
    }

}
