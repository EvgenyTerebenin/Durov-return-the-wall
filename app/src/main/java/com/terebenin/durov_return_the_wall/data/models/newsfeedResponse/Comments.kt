package com.terebenin.durov_return_the_wall.data.models.newsfeedResponse

import com.google.gson.annotations.SerializedName


data class Comments(

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("groups_can_post")
    val groupsCanPost: Boolean? = null,

    @field:SerializedName("can_post")
    val canPost: Int? = null
)