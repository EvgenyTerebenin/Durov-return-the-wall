package com.terebenin.durov_return_the_wall.presentation.newsfeed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.terebenin.durov_return_the_wall.R
import com.terebenin.durov_return_the_wall.data.newsfeed.response.Attachments
import com.terebenin.durov_return_the_wall.databinding.ItemNewsfeedBinding
import com.terebenin.durov_return_the_wall.domain.global.toDateTimeString
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.PostAuthorType
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.PostItemDomainModel
import kotlinx.android.synthetic.main.item_newsfeed.view.*


class NewsfeedAdapter(private val viewModel: NewsfeedViewModel) :
    ListAdapter<PostItemDomainModel, NewsfeedAdapter.NewsfeedViewHolder>(
        DiffCallback()
    ) {
    private lateinit var context: Context
    private val imageViewDoubleHeight: Int = 96


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsfeedViewHolder {
        return NewsfeedViewHolder(
            ItemNewsfeedBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), viewModel
        )
    }

    override fun onBindViewHolder(holder: NewsfeedViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.item
        context = holder.binding.textViewPostOwner.context
        holder.itemView.text_view_post_owner.text = getPostOwnerName(holder.binding.item)
        loadAvatar(holder)
//        setDate()
        holder.itemView.text_view_post_date.text =
            holder.binding.item?.date!!.toDateTimeString()
        holder.binding.item?.attachments?.let {
            holder.itemView.text_view_images_count.text =
                context.resources.getString(
                    R.string.text_how_many_photos_in_post(
                        getAttachedPhotos(it).size.toString()
                    )
                )
        }
    }

    private fun loadAvatar(holder: NewsfeedViewHolder) {
        Glide.with(
            holder.itemView.image_view_post_owner_avatar
        )
            .load(getAvatarUrl(holder.binding.item))
            .centerCrop()
            .transform(RoundedCorners(imageViewDoubleHeight))
            //            .placeholder()
            .into(holder.itemView.image_view_post_owner_avatar)
    }

    private fun getAvatarUrl(item: PostItemDomainModel?): String {
        return when (item?.postType) {
            PostAuthorType.User -> {
                item.profile?.photo100 ?: ""
            }
            PostAuthorType.Group -> {
                item.group?.photo100 ?: ""
            }
            null -> ""
        }
    }

    private fun getPostOwnerName(item: PostItemDomainModel?): String {
        return when (item?.postType) {
            PostAuthorType.User -> {
                context.getString(
                    R.string.text_user_name,
                    item.profile?.firstName,
                    item.profile?.lastName
                )
            }
            PostAuthorType.Group -> {
                item.group?.name ?: ""
            }
            null -> ""
        }
    }

    private fun getAttachedPhotos(attachments: List<Attachments?>): List<Attachments> {
        val photos = mutableListOf<Attachments>()

        for (i in attachments) {
            if (i?.type == "photo") {
                photos.add(i)
            }
        }
        return photos
    }

    class NewsfeedViewHolder(
        val binding: ItemNewsfeedBinding,
        private val viewModel: NewsfeedViewModel
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: PostItemDomainModel) {
            binding.eventHandler = viewModel
            binding.item = model
            binding.executePendingBindings()
        }

    }


    class DiffCallback : DiffUtil.ItemCallback<PostItemDomainModel>() {
        override fun areItemsTheSame(
            oldItem: PostItemDomainModel,
            newItem: PostItemDomainModel
        ): Boolean {
            return oldItem.postId == newItem.postId
        }

        override fun areContentsTheSame(
            oldItem: PostItemDomainModel,
            newItem: PostItemDomainModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}