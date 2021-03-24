package com.terebenin.durov_return_the_wall.di

import com.terebenin.durov_return_the_wall.data.datasource.network.VkApi
import com.terebenin.durov_return_the_wall.data.datasource.network.VkApiFactory
import com.terebenin.durov_return_the_wall.data.newsfeed.NewsfeedRepositoryImpl
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedRepository
import com.terebenin.durov_return_the_wall.presentation.newsfeed.NewsfeedViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by evgenyterebenin at 23.03.2021
 */
@Module
class NewsfeedModule {

    @Provides
    fun providesNewsfeedViewModel(interactor: NewsfeedInteractor) = NewsfeedViewModel(interactor)

    @Provides
    fun providesNewsfeedInteractor(repository: NewsfeedRepository) = NewsfeedInteractor(repository)

    @Provides
    fun providesNewsNewsfeedRepository(vkApi: VkApi) = NewsfeedRepositoryImpl(vkApi)

    @Provides
    fun providesVkApi() = VkApiFactory.vkApi

}