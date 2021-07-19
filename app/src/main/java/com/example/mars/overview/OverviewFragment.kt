package com.example.mars.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mars.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {
    private val viewModel:OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentOverviewBinding.inflate(inflater,container,false)
        binding.lifecycleOwner=this
        binding.viewModel=viewModel
        binding.photoGrid.adapter=PhotoGridAdapter()
        return binding.root
    }
}