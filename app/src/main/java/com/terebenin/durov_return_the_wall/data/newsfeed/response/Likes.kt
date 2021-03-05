package com.terebenin.durov_return_the_wall.data.newsfeed.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Likes(

    @field:SerializedName("user_likes")
    val userLikes: Int? = null,

    @field:SerializedName("can_publish")
    val canPublish: Int? = null,

    @field:SerializedName("can_like")
    val canLike: Int? = null,

    @field:SerializedName("count")
    val count: Int? = null
) : Parcelable