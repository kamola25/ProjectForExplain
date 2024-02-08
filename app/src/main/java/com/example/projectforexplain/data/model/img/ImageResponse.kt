package com.example.projectforexplain.data.model.img

data class ImageResponse<T>(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)