package com.example.project_1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.project_1.databinding.FragmentAddShoeBinding

class AddShoeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddShoeBinding.bind(
            inflater.inflate(
                R.layout.fragment_add_shoe,
                container,
                false
            )
        )

        val viewModel = ViewModelProvider(requireActivity()).get(ViewModel::class.java);

        val shoe: Shoe = Shoe()

        binding.nameField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                shoe.name = s.toString()
            }
        })

        binding.companyField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                shoe.company = s.toString()
            }
        })
        binding.sizeField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                shoe.size = s.toString()
            }
        })
        binding.descriptionField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                shoe.description = s.toString()
            }
        })


        binding.submitButton.setOnClickListener {
            viewModel.listShoe.value?.add(shoe)
            it.findNavController()
                .navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())
        }

        binding.cancelButton.setOnClickListener {
            it.findNavController()
                .navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())
        }
        return binding.root
    }
}