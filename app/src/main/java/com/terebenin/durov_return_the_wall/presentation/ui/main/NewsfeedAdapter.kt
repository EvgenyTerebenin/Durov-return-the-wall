package com.terebenin.durov_return_the_wall.presentation.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.terebenin.durov_return_the_wall.data.models.newsfeedResponse.ItemsItem
import com.terebenin.durov_return_the_wall.presentation.mvvm.main.NewsfeedViewModel

class NewsfeedAdapter(viewmodel: NewsfeedViewModel) :
    ListAdapter<ItemsItem, NewsfeedAdapter.NewsfeedViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsfeedViewHolder {
        return NewsfeedViewHolder(
//TODO
        )
    }

    override fun onBindViewHolder(holder: NewsfeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NewsfeedViewHolder(
        val binding:,
        val viewmodel: NewsfeedViewModel
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ItemsItem) {
            binding.eventHandler = viewmodel,
            binding.item = model,
            binding.executePendingBindings()
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<ItemsItem>() {
        override fun areItemsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
            return oldItem.sourceId == newItem.sourceId
        }

        override fun areContentsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
            return oldItem == newItem
        }
    }
}