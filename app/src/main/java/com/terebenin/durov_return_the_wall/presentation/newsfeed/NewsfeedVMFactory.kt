package com.terebenin.durov_return_the_wall.presentation.newsfeed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor

class NewsfeedVMFactory(private val interactor: NewsfeedInteractor) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsfeedViewModel(
            interactor
        ) as T
    }
}
