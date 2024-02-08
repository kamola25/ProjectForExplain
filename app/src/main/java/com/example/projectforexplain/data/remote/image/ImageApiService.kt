package com.example.projectforexplain.data.remote.image

import com.example.projectforexplain.BuildConfig.API_KEY
import com.example.projectforexplain.data.model.img.Hit
import com.example.projectforexplain.data.model.img.ImageResponse
import com.example.projectforexplain.data.model.video.VideoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApiService {
    @GET("/api/")
    suspend fun getImage(@Query("page")page:Int?=null,
                 @Query("per_page") per_page: Int? = null,
                 @Query("key") key : String = API_KEY
    ):Response<ImageResponse<Hit>>

    @GET("/api/videos")
    suspend fun getVideo(@Query("page")page:Int?=null,
                         @Query("per_page") per_page: Int? = null,
                         @Query("key") key : String = API_KEY
    ):Response<VideoResponse<com.example.projectforexplain.data.model.video.Hit>>


}