package com.terebenin.durov_return_the_wall.data.models.newsfeedResponse

import com.google.gson.annotations.SerializedName



data class Response(

    @field:SerializedName("next_from")
    val nextFrom: String? = null,

    @field:SerializedName("profiles")
    val profiles: List<ProfilesItem?>? = null,

    @field:SerializedName("groups")
    val groups: List<GroupsItem?>? = null,

    @field:SerializedName("items")
    val items: List<ItemsItem?>? = null
)