package com.terebenin.durov_return_the_wall.domain.newsfeed.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GroupDomainModel(
    val id: Int? = null,
    val name: String? = null,
    val photo50: String? = null
) : Parcelable