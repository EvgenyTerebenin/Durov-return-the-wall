package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName


data class Response(

    @field:SerializedName("next_from")
    val nextFrom: String? = null,

    @field:SerializedName("profiles")
    val profiles: List<Profile?>? = null,

    @field:SerializedName("groups")
    val groups: List<Groups?>? = null,

    @field:SerializedName("items")
    val items: List<Item?>? = null
)