package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName


data class Groups(

    @field:SerializedName("photo_50")
    val photo50: String? = null,

    @field:SerializedName("screen_name")
    val screenName: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("photo_100")
    val photo100: String? = null,

    @field:SerializedName("photo_200")
    val photo200: String? = null,

    @field:SerializedName("is_closed")
    val isClosed: Int? = null
)