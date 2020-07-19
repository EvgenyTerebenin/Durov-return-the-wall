package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.*
import kotlin.math.abs


data class Response(

    @field:SerializedName("next_from")
    val nextFrom: String? = null,

    @field:SerializedName("profiles")
    val profiles: List<Profile?>? = null,

    @field:SerializedName("groups")
    val groups: List<Groups?>? = null,

    @field:SerializedName("items")
    val items: List<Item?>? = null

)

internal fun Response.toDomainModel(): NewsfeedResponseDomainModel {
    var domainItems: MutableList<PostItemDomainModel> = mutableListOf()
    items?.let {
        for (item in items) {
            domainItems.add(createDomainPostItemModel(this, item))
        }
    }
    return NewsfeedResponseDomainModel(domainItems)
}

fun createDomainPostItemModel(response: Response, item: Item?): PostItemDomainModel {
    return PostItemDomainModel(
        item?.sourceId,
        item?.date,
        item?.postId,
        item?.text,
        item?.views,
        item?.likes,
        getProfileBySourceId(response.profiles, item?.sourceId),
        getGroupBySourceId(response.groups, item?.sourceId),
        getPostAuthorType(item?.sourceId)
    )
}


private fun getPostAuthorType(sourceId: Int?): PostAuthorType? {
    return if (sourceId!! > 0) PostAuthorType.User else PostAuthorType.Group
}

private fun getGroupBySourceId(groups: List<Groups?>?, sourceId: Int?): GroupDomainModel? {
    var domainGroupItem: GroupDomainModel? = null
    groups?.let {
        for (group in groups) {
            if (group?.id == abs(sourceId!!))
                domainGroupItem = GroupDomainModel(
                    group.id,
                    group.name,
                    group.photo50
                )
        }
    }
    return domainGroupItem
}

private fun getProfileBySourceId(profiles: List<Profile?>?, sourceId: Int?): ProfileDomainModel? {
    var domainProfileItem: ProfileDomainModel? = null
    profiles?.let {
        for (profile in profiles) {
            if (profile!!.id == sourceId!!)
                domainProfileItem = ProfileDomainModel(
                    profile.id,
                    profile.firstName,
                    profile.lastName,
                    profile.photo50
                )
        }
    }
    return domainProfileItem
}
