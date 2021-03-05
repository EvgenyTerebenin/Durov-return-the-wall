package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName


data class NewsfeedResponse(

    @field:SerializedName("response")
    val response: Response? = null
)