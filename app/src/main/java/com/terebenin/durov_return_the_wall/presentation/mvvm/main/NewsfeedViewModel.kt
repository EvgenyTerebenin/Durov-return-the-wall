package com.terebenin.durov_return_the_wall.mvvm

import androidx.lifecycle.ViewModel
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor

class NewsfeedViewModel(private val interactor: NewsfeedInteractor) : ViewModel() {

    init {
        interactor.getNewsFeed()
    }

}
