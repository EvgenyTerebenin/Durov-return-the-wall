package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName


data class ImageItem(

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("with_padding")
    val withPadding: Int? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("height")
    val height: Int? = null
)