package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.*
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import kotlin.math.abs


data class Response(

    @field:SerializedName("next_from")
    val nextFrom: String? = null,

    @field:SerializedName("profiles")
    val profiles: List<Profile?>? = null,

    @field:SerializedName("groups")
    val groups: List<Group?>? = null,

    @field:SerializedName("items")
    val items: List<Item?>? = null

)

internal fun Response.toDomainModel(): NewsfeedResponseDomainModel {
    var domainItems: MutableList<PostItemDomainModel> = mutableListOf()
    items?.let {
        for (item in items) {
            item?.attachments?.let {
                if (findOnlyPhotoAttachments(item).isNotEmpty()) {
                    item.attachments = findOnlyPhotoAttachments(item)
                    domainItems.add(
                        createDomainPostItemModel(
                            this,
                            item
                        )
                    )
                }
            }
        }
    }
    return NewsfeedResponseDomainModel(domainItems)
}

private fun findOnlyPhotoAttachments(
    item: Item
): MutableList<Attachments> {
    val attachedPhotos = mutableListOf<Attachments>()
    for (i in item.attachments!!) {
        if (i?.type == "photo") {
            attachedPhotos.add(i)
        }
    }
    return attachedPhotos
}

fun createDomainPostItemModel(response: Response, item: Item?): PostItemDomainModel {
    return PostItemDomainModel(
        item?.sourceId,
        convertUnixTimeToZonedDateTime(item?.date),
        item?.postId,
        item?.text,
        item?.views,
        item?.likes,
        getProfileBySourceId(response.profiles, item?.sourceId),
        getGroupBySourceId(response.groups, item?.sourceId),
        getPostAuthorType(item?.sourceId),
        item?.attachments
    )
}

private fun convertUnixTimeToZonedDateTime(unixTime: Long?): ZonedDateTime {
    var i: Instant = Instant.ofEpochSecond(unixTime!!.toLong())
    return ZonedDateTime.ofInstant(i, ZoneId.systemDefault())
}


private fun getPostAuthorType(sourceId: Int?): PostAuthorType? {
    return if (sourceId!! > 0) PostAuthorType.User else PostAuthorType.Group
}

private fun getGroupBySourceId(groups: List<Group?>?, sourceId: Int?): GroupDomainModel? {
    var domainGroupItem: GroupDomainModel? = null
    groups?.let {
        for (group in groups) {
            if (group?.id == abs(sourceId!!))
                domainGroupItem = GroupDomainModel(
                    group.id,
                    group.name,
                    group.photo100
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
                    profile.photo100
                )
        }
    }
    return domainProfileItem
}
