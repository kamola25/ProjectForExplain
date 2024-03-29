package com.example.projectforexplain.ui.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: AppCompatActivity, private val fragment: List<Fragment>): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = fragment.size

    override fun createFragment(position: Int): Fragment = fragment[position]
}