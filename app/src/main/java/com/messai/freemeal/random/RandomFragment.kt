package com.messai.freemeal.random

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.messai.freemeal.R
import com.messai.freemeal.databinding.RandomFragmentBinding

class RandomFragment : Fragment() {

    private val viewModel: RandomViewModel by lazy {
        ViewModelProvider(this).get(RandomViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = RandomFragmentBinding.inflate(inflater)
        return binding.root
    }


}