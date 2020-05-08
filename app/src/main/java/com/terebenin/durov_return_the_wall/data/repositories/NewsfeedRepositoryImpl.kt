package com.terebenin.durov_return_the_wall.data.repositories

import com.terebenin.durov_return_the_wall.BuildConfig
import com.terebenin.durov_return_the_wall.data.datasource.server.VkApi
import com.terebenin.durov_return_the_wall.domain.global.repositories.NewsfeedRepository
import com.terebenin.durov_return_the_wall.presentation.ui.global.VkApplication

class NewsfeedRepositoryImpl(private val vkApi: VkApi) : NewsfeedRepository {

    override fun getNewsfeed() {
        VkApplication.prefs.accessToken.token?.let {
            vkApi.getNewsfeed(
                BuildConfig.API_VERSION,
                it
            )
        }
    }
}