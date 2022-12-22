package com.example.project_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.project_1.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = FragmentWelcomeBinding.bind(inflater.inflate(R.layout.fragment_welcome, container, false))
        binding.floatingActionButton4.setOnClickListener{
            it.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }
        return binding.root

    }

}