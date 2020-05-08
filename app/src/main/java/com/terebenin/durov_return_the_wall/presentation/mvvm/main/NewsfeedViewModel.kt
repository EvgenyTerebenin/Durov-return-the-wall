package com.terebenin.durov_return_the_wall.presentation.mvvm.main

import androidx.lifecycle.ViewModel
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor

class NewsfeedViewModel(interactor: NewsfeedInteractor) : ViewModel() {

    init {
        interactor.getNewsFeed()
    }

}
