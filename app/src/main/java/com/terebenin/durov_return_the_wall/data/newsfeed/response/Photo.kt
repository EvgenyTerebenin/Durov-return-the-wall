package com.terebenin.durov_return_the_wall.data.newsfeed.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(

    @field:SerializedName("date")
    val date: Int? = null,

    @field:SerializedName("sizes")
    val sizes: List<Size?>? = null,

    @field:SerializedName("user_id")
    val userId: Int? = null,

    @field:SerializedName("owner_id")
    val ownerId: Int? = null,

    @field:SerializedName("access_key")
    val accessKey: String? = null,

    @field:SerializedName("album_id")
    val albumId: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("text")
    val text: String? = null
) : Parcelable