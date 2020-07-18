package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName


data class Item(

    @field:SerializedName("date")
    val date: Int? = null,

    @field:SerializedName("attachments")
    val attachments: List<Attachments?>? = null,

    @field:SerializedName("comments")
    val comments: Comments? = null,

    @field:SerializedName("is_favorite")
    val isFavorite: Boolean? = null,

    @field:SerializedName("can_set_category")
    val canSetCategory: Boolean? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("can_doubt_category")
    val canDoubtCategory: Boolean? = null,

    @field:SerializedName("post_id")
    val postId: Int? = null,

    @field:SerializedName("post_source")
    val postSource: PostSource? = null,

    @field:SerializedName("marked_as_ads")
    val markedAsAds: Int? = null,

    @field:SerializedName("post_type")
    val postType: String? = null,

    @field:SerializedName("source_id")
    val sourceId: Int? = null,

    @field:SerializedName("text")
    val text: String? = null,

    @field:SerializedName("reposts")
    val reposts: Reposts? = null,

    @field:SerializedName("views")
    val views: Views? = null,

    @field:SerializedName("likes")
    val likes: Likes? = null
)