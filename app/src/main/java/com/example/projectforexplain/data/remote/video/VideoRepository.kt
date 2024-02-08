package com.example.projectforexplain.data.remote.video

import com.example.projectforexplain.core.UiState

import com.example.projectforexplain.data.model.video.VideoResponse
import com.example.projectforexplain.data.remote.image.ImageApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VideoRepository @Inject constructor(private val apiServiceVideo: ImageApiService) {
    fun getVideo(page : Int, per_page : Int): kotlinx.coroutines.flow.Flow<UiState<VideoResponse<com.example.projectforexplain.data.model.video.Hit>>> = flow{
        val responseVideo = apiServiceVideo.getVideo(page = page, per_page = per_page)
        if(responseVideo.isSuccessful){
            val videoResponse = responseVideo.body()
            if(videoResponse!= null){
                emit(UiState.Success(videoResponse))
            }else{
                emit(UiState.Error("No Data!"))
            }
        }else{
            emit(UiState.Error("Connect error check int!"))
        }
    }
}