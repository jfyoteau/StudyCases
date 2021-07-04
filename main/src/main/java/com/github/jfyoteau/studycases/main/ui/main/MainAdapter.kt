package com.github.jfyoteau.studycases.main.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.jfyoteau.studycases.main.databinding.MainItemBinding

class MainAdapter(private val viewModel: MainViewModel) : ListAdapter<MainViewModel.MenuValue, MainAdapter.ListViewHolder>(DiffCallback()) {

    class ListViewHolder(val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root)

    class DiffCallback : DiffUtil.ItemCallback<MainViewModel.MenuValue>() {

        override fun areItemsTheSame(
            oldItem: MainViewModel.MenuValue,
            newItem: MainViewModel.MenuValue
        ): Boolean =
            oldItem.label == newItem.label

        override fun areContentsTheSame(
            oldItem: MainViewModel.MenuValue,
            newItem: MainViewModel.MenuValue
        ): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        with(holder.binding) {
            data = currentList[position]
            viewModel = this@MainAdapter.viewModel
            executePendingBindings()
        }
    }

}
