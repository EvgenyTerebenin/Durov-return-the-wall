package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName


data class Reposts(

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("user_reposted")
    val userReposted: Int? = null
)