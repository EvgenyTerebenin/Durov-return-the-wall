package com.terebenin.durov_return_the_wall.presentation.mvvm.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor

class NewsfeedVMFactory(private val interactor: NewsfeedInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsfeedVMFactory(interactor).create(NewsfeedViewModel::class.java) as T
    }
}