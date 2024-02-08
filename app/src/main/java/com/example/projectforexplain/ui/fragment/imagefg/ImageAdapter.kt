package com.example.projectforexplain.ui.fragment.imagefg

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.projectforexplain.data.model.img.Hit
import com.example.projectforexplain.databinding.ItemImgBinding

class ImageAdapter : ListAdapter<Hit, ImageAdapter.ImageViewHolder>(ImageDiffCallback) {

    inner class ImageViewHolder(private val binding: ItemImgBinding) : ViewHolder(binding.root) {
        fun bind(model: Hit) {
            Glide.with(binding.root).load(model.webformatURL).centerCrop().into(binding.itemImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(
        ItemImgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val itemPos = getItem(position)
        holder.bind(itemPos)
    }

    object ImageDiffCallback : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem == newItem
        }

    }
}