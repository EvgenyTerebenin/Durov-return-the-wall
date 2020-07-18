package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName
import com.terebenin.durov_return_the_wall.data.newsfeed.response.Response


data class NewsfeedResponse(

    @field:SerializedName("response")
    val response: Response? = null
)