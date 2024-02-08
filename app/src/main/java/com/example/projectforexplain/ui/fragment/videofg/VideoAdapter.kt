package com.example.projectforexplain.ui.fragment.videofg

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.projectforexplain.databinding.ItemVideoBinding

class VideoAdapter : ListAdapter<com.example.projectforexplain.data.model.video.Hit, VideoAdapter.VideoViewHolder>(VideoDiffCallback) {

    inner class VideoViewHolder(private val binding: ItemVideoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: com.example.projectforexplain.data.model.video.Hit) {
        val videoView = binding.itemVideo
            videoView.setVideoURI(Uri.parse(model.videos.medium.url))
            val mediaController = MediaController(videoView.context)
            videoView.setMediaController(mediaController)
            videoView.setOnPreparedListener {
                videoView.seekTo(model.videos.medium.url.length)
                videoView.start()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VideoViewHolder(
        ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val itemPos = getItem(position)
        holder.bind(itemPos)
    }

    object VideoDiffCallback : DiffUtil.ItemCallback<com.example.projectforexplain.data.model.video.Hit>() {
        override fun areItemsTheSame(
            oldItem: com.example.projectforexplain.data.model.video.Hit,
            newItem: com.example.projectforexplain.data.model.video.Hit
        ): Boolean {
          return oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: com.example.projectforexplain.data.model.video.Hit,
            newItem: com.example.projectforexplain.data.model.video.Hit
        ): Boolean {
            return oldItem==newItem
        }

    }
}