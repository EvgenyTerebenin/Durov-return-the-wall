package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName


data class Video(

    @field:SerializedName("date")
    val date: Int? = null,

    @field:SerializedName("image")
    val image: List<ImageItem?>? = null,

    @field:SerializedName("comments")
    val comments: Int? = null,

    @field:SerializedName("can_add_to_faves")
    val canAddToFaves: Int? = null,

    @field:SerializedName("owner_id")
    val ownerId: Int? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("can_subscribe")
    val canSubscribe: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("platform")
    val platform: String? = null,

    @field:SerializedName("can_repost")
    val canRepost: Int? = null,

    @field:SerializedName("duration")
    val duration: Int? = null,

    @field:SerializedName("can_comment")
    val canComment: Int? = null,

    @field:SerializedName("local_views")
    val localViews: Int? = null,

    @field:SerializedName("can_like")
    val canLike: Int? = null,

    @field:SerializedName("access_key")
    val accessKey: String? = null,

    @field:SerializedName("track_code")
    val trackCode: String? = null,

    @field:SerializedName("can_add")
    val canAdd: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("views")
    val views: Int? = null
)