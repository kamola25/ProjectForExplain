package com.example.projectforexplain.data.model.video

data class VideoResponse<T>(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)