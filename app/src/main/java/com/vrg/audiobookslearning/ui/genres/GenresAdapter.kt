package com.vrg.audiobookslearning.ui.genres

import com.vrg.audiobookslearning.databinding.GeneresItemBinding


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.vrg.audiobookslearning.model.GenresItem


class GenresAdapter : RecyclerView.Adapter<GenresAdapter.ViewHolder>() {

    private var list: MutableList<GenresItem> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: GeneresItemBinding =
            GeneresItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun updateList(newList: List<GenresItem>) {
        list.apply {
            clear()
            list.addAll(newList)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(private val binding: GeneresItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: GenresItem) {
            binding.idTVHeading.text = item.name
            binding.genresImv.setImageResource(item.image)
        }
    }


    class DiffUtilCallback(
        private var newList: MutableList<GenresItem>,
        private var oldList: MutableList<GenresItem>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return newList[newItemPosition].name == oldList[oldItemPosition].name
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return newList[newItemPosition].image == oldList[oldItemPosition].image
        }
    }

}