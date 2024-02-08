package com.example.projectforexplain.ui.fragment.videofg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectforexplain.core.UiState
import com.example.projectforexplain.data.model.video.VideoResponse
import com.example.projectforexplain.data.remote.video.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(private val repository : VideoRepository) : ViewModel(){
    private val _data1 = MutableStateFlow<UiState<VideoResponse<com.example.projectforexplain.data.model.video.Hit>>>(UiState.Loading())
    val data: MutableStateFlow<UiState<VideoResponse<com.example.projectforexplain.data.model.video.Hit>>> = _data1

    fun fetchVideo(page:Int, perPage: Int){
        viewModelScope.launch {
            repository.getVideo(page,perPage).collect{
                 _data1.value = it
            }
        }
    }
}