package com.terebenin.durov_return_the_wall.domain.newsfeed.model

import android.os.Parcelable
import com.terebenin.durov_return_the_wall.data.newsfeed.response.Likes
import com.terebenin.durov_return_the_wall.data.newsfeed.response.Views
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.ZonedDateTime

@Parcelize
data class PostItemDomainModel(

    val sourceId: Int? = null,

    val date: ZonedDateTime,

    val postId: Int? = null,

    val text: String? = null,

    val views: Views? = null,

    val likes: Likes? = null,

    val profile: ProfileDomainModel? = null,

    val group: GroupDomainModel? = null,

    val postType: PostAuthorType? = null
) : Parcelable