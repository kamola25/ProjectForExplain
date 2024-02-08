package com.example.projectforexplain.ui.fragment.imagefg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectforexplain.core.UiState
import com.example.projectforexplain.data.model.img.Hit
import com.example.projectforexplain.data.model.img.ImageResponse
import com.example.projectforexplain.data.remote.image.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(private val repo: ImageRepository): ViewModel(){
    private val _data = MutableStateFlow<UiState<ImageResponse<Hit>>>(UiState.Loading())
    val data: StateFlow<UiState<ImageResponse<Hit>>> = _data

    fun fetchImage(page:Int, perPage: Int){
      viewModelScope.launch {
          repo.getImage(page,perPage).collect{
              _data.value = it
          }
      }
    }
}