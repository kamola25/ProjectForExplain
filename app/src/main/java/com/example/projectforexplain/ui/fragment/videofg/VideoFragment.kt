package com.example.projectforexplain.ui.fragment.videofg


import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.projectforexplain.core.BaseFragment
import com.example.projectforexplain.core.UiState
import com.example.projectforexplain.databinding.FragmentVideoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class VideoFragment : BaseFragment<FragmentVideoBinding>(FragmentVideoBinding::inflate) {
    private var page: Int = 1
    private val perPage: Int = 30
    private lateinit var adapter: VideoAdapter
    private lateinit var viewModel: VideoViewModel
    override fun setUpUI() {
        adapter = VideoAdapter()
        binding?.rvViewVideo?.adapter = adapter
        viewModel = ViewModelProvider(this)[VideoViewModel::class.java]
        makeUi()
        viewModel.fetchVideo(page,perPage)

    }
    private fun makeUi(){
        lifecycleScope.launchWhenCreated {
            viewModel.data.collect{
                when(it){
                    is UiState.Error->{
                        binding?.progressBarVideo?.visibility = View.GONE
                        Log.e("exexe", it.msg.toString())
                        Toast.makeText(requireContext(), "Something went error", Toast.LENGTH_SHORT)
                            .show()
                    }
                    is UiState.Loading -> binding?.progressBarVideo?.visibility = View.VISIBLE
                    is UiState.Success -> {
                        val data = it.data?.hits
                        Log.e("exexe", "$data")
                        if (data != null) {
                            adapter.submitList(data)
                            binding?.progressBarVideo?.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }
}