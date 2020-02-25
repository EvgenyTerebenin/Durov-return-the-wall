package com.terebenin.durov_return_the_wall.data.models.newsfeedResponse

import com.google.gson.annotations.SerializedName



data class ProfilesItem(

    @field:SerializedName("can_access_closed")
    val canAccessClosed: Boolean? = null,

    @field:SerializedName("photo_50")
    val photo50: String? = null,

    @field:SerializedName("screen_name")
    val screenName: String? = null,

    @field:SerializedName("sex")
    val sex: Int? = null,

    @field:SerializedName("last_name")
    val lastName: String? = null,

    @field:SerializedName("online")
    val online: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("photo_100")
    val photo100: String? = null,

    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("is_closed")
    val isClosed: Boolean? = null,

    @field:SerializedName("online_info")
    val onlineInfo: OnlineInfo? = null
)