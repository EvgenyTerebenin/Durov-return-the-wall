package com.terebenin.durov_return_the_wall.presentation.newsfeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.terebenin.durov_return_the_wall.data.newsfeed.response.Item
import com.terebenin.durov_return_the_wall.databinding.ItemNewsfeedBinding

class NewsfeedAdapter(private val viewmodel: NewsfeedViewModel) :
    ListAdapter<Item, NewsfeedAdapter.NewsfeedViewHolder>(
        DiffCallback()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsfeedViewHolder {
        return NewsfeedViewHolder(
            ItemNewsfeedBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), viewmodel
        )
    }

    override fun onBindViewHolder(holder: NewsfeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NewsfeedViewHolder(
        private val binding: ItemNewsfeedBinding,
        private val viewmodel: NewsfeedViewModel
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Item) {
            binding.eventHandler = viewmodel
            binding.item = model
            binding.executePendingBindings()
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.postId == newItem.postId
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}