package com.terebenin.durov_return_the_wall.domain.newsfeed.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileDomainModel(
    val id: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val photo50: String? = null
) : Parcelable