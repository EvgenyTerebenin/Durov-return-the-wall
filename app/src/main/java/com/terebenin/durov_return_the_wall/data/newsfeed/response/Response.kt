package com.terebenin.durov_return_the_wall.data.newsfeed.response

import com.google.gson.annotations.SerializedName
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.GroupDomainModel
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.PostAuthorType
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.PostItemDomainModel
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.ProfileDomainModel


data class Response(

    @field:SerializedName("next_from")
    val nextFrom: String? = null,

    @field:SerializedName("profiles")
    val profiles: List<Profile?>? = null,

    @field:SerializedName("groups")
    val groups: List<Groups?>? = null,

    @field:SerializedName("items")
    val items: List<Item?>? = null

) {
    internal fun Response.toDomainModel(): List<PostItemDomainModel> {
        var domainItems: MutableList<PostItemDomainModel> = mutableListOf()
        items?.let {
            for (item in items) {
                addDomainPostItemModel(domainItems, item)
            }
        }
        return domainItems
    }

    private fun addDomainPostItemModel(
        domainItems: MutableList<PostItemDomainModel>,
        item: Item?
    ) {
        domainItems.add(
            PostItemDomainModel(
                item?.sourceId,
                item?.date,
                item?.postId,
                item?.text,
                item?.views,
                item?.likes,
                getProfileBySourceId(item?.sourceId),
                getGroupBySourceId(item?.sourceId),
                getPostAuthorType(item?.sourceId)
            )
        )
    }

    private fun getPostAuthorType(sourceId: Int?): PostAuthorType? {
        return if (sourceId!! > 0) PostAuthorType.User else PostAuthorType.Group
    }

    private fun getGroupBySourceId(sourceId: Int?): GroupDomainModel? {
        var domainGroupItem: GroupDomainModel? = null
        groups?.let {
            for (group in groups) {
                if (group!!.id == sourceId!!)
                    domainGroupItem = GroupDomainModel(
                        group.id,
                        group.name,
                        group.photo50
                    )
            }
        }
        return domainGroupItem
    }

    private fun getProfileBySourceId(sourceId: Int?): ProfileDomainModel? {
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
}