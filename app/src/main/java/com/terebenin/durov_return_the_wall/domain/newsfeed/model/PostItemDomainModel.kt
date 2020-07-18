package com.terebenin.durov_return_the_wall.domain.newsfeed.model

import com.terebenin.durov_return_the_wall.data.newsfeed.response.Likes
import com.terebenin.durov_return_the_wall.data.newsfeed.response.Views

data class PostItemDomainModel(

    val sourceId: Int? = null,

    val date: Int? = null,

    val postId: Int? = null,

    val text: String? = null,

    val views: Views? = null,

    val likes: Likes? = null,

    val profile: ProfileDomainModel? = null,

    val group: GroupDomainModel? = null,

    val postType: PostAuthorType? = null
)