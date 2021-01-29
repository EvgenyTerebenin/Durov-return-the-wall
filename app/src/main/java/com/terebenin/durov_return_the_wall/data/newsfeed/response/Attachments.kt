package com.terebenin.durov_return_the_wall.data.newsfeed.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Attachments(

    @field:SerializedName("photo")
    val photo: Photo? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("video")
    val video: Video? = null
) : Parcelable