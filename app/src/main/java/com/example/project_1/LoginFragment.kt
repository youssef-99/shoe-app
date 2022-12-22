package com.example.project_1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.project_1.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding =
            FragmentLoginBinding.bind(inflater.inflate(R.layout.fragment_login, container, false))

        binding.loginButton.setOnClickListener {
            onClick(it)
        }
        binding.registerButton.setOnClickListener {
            onClick(it)
        }
        return binding.root
    }

    private fun onClick(view: View) {
        view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }

}