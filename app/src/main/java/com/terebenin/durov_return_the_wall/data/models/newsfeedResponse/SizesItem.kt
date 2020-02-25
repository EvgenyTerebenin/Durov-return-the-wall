package com.terebenin.durov_return_the_wall.data.models.newsfeedResponse

import com.google.gson.annotations.SerializedName



data class SizesItem(

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("height")
    val height: Int? = null
)