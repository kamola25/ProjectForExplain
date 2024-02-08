package com.example.projectforexplain.ui.fragment.imagefg

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.projectforexplain.core.BaseFragment
import com.example.projectforexplain.core.UiState
import com.example.projectforexplain.databinding.FragmentImageBinding
import com.example.projectforexplain.ui.fragment.imagefg.ImageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageFragment : BaseFragment<FragmentImageBinding>(FragmentImageBinding::inflate) {
    private var page: Int = 1
    private val perPage: Int = 30
    private lateinit var adapter: ImageAdapter
    private lateinit var viewModel: ImageViewModel


    override fun setUpUI() {
        adapter = ImageAdapter()
        binding?.rvView?.adapter = adapter
        viewModel = ViewModelProvider(this)[ImageViewModel::class.java]
        checkUi()
        viewModel.fetchImage(page, perPage)
    }

    private fun checkUi() {
        lifecycleScope.launchWhenStarted {
            viewModel.data.collect {
                when (it) {
                    is UiState.Error -> {
                        binding?.progressBar?.visibility = View.GONE
                        Log.e("ololo", it.msg.toString())
                        Toast.makeText(requireContext(), "Something went error", Toast.LENGTH_SHORT)
                            .show()
                    }

                    is UiState.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                    is UiState.Success -> {
                        val data = it.data?.hits
                        Log.e("ololo", "$data")
                        if (data != null) {
                            adapter.submitList(data)
                            binding?.progressBar?.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }
}