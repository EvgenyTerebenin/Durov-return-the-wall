package com.terebenin.durov_return_the_wall.data.newsfeed.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Views(

    @field:SerializedName("count")
    val count: Int? = null
) : Parcelable