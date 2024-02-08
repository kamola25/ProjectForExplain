package com.example.projectforexplain.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectforexplain.databinding.ActivityMainBinding
import com.example.projectforexplain.ui.fragment.imagefg.ImageFragment
import com.example.projectforexplain.ui.fragment.videofg.VideoFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val fgList = listOf(ImageFragment(), VideoFragment())
    private val title = listOf("Image","Video")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
        viewPager.adapter = PagerAdapter(this@MainActivity, fgList)
        TabLayoutMediator(tabLay,viewPager){tab, possition->
        tab.text = title[possition]
        }.attach()
    }}
}