package com.terebenin.durov_return_the_wall.presentation.newsfeed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.terebenin.durov_return_the_wall.R
import com.terebenin.durov_return_the_wall.databinding.ItemNewsfeedBinding
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.PostAuthorType
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.PostItemDomainModel
import com.terebenin.durov_return_the_wall.presentation.global.TImeUtils
import kotlinx.android.synthetic.main.item_newsfeed.view.*


class NewsfeedAdapter(private val viewModel: NewsfeedViewModel) :
    ListAdapter<PostItemDomainModel, NewsfeedAdapter.NewsfeedViewHolder>(
        DiffCallback()
    ) {
    private lateinit var context: Context


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
            TImeUtils.dateTimeString(holder.binding.item?.date!!)
    }

    private fun loadAvatar(holder: NewsfeedViewHolder) {
        Glide.with(
            holder.itemView.image_view_post_owner_avatar
        )
            .load(getAvatarUrl(holder.binding.item))
            .centerCrop()
            //            .placeholder()
            .into(holder.itemView.image_view_post_owner_avatar)
    }

    private fun getAvatarUrl(item: PostItemDomainModel?): String {
        return when (item?.postType) {
            PostAuthorType.User -> {
                item.profile?.photo50 ?: ""
            }
            PostAuthorType.Group -> {
                item.group?.photo50 ?: ""
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