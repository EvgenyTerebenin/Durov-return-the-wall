package com.terebenin.durov_return_the_wall.presentation.newsfeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.terebenin.durov_return_the_wall.databinding.ItemNewsfeedBinding
import com.terebenin.durov_return_the_wall.domain.newsfeed.model.PostItemDomainModel

class NewsfeedAdapter(private val viewModel: NewsfeedViewModel) :
    ListAdapter<PostItemDomainModel, NewsfeedAdapter.NewsfeedViewHolder>(
        DiffCallback()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsfeedViewHolder {
        return NewsfeedViewHolder(
            ItemNewsfeedBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), viewModel
        )
    }

    override fun onBindViewHolder(holder: NewsfeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NewsfeedViewHolder(
        private val binding: ItemNewsfeedBinding,
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