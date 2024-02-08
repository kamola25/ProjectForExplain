package com.example.projectforexplain.data.remote.image

import com.example.projectforexplain.core.UiState
import com.example.projectforexplain.data.model.img.Hit
import com.example.projectforexplain.data.model.img.ImageResponse
import com.example.projectforexplain.data.remote.image.ImageApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ImageRepository @Inject constructor(private val apiService: ImageApiService){
    fun getImage(page : Int, per_page : Int): kotlinx.coroutines.flow.Flow<UiState<ImageResponse<Hit>>> = flow{
     val response = apiService.getImage(page = page, per_page = per_page)
        if(response.isSuccessful){
            val imageResponse = response.body()
            if(imageResponse!= null){
                emit(UiState.Success(imageResponse))
            }else{
                emit(UiState.Error("No Data!"))
            }
        }else{
            emit(UiState.Error("Connect error check int!"))
        }
    }

}