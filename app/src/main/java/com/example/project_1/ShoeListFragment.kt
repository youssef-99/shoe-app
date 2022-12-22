package com.example.project_1

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.project_1.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {
    private lateinit var  binding: FragmentShoeListBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this
        binding.shoeListViewModel = viewModel

        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        viewModel.currentList.observe(viewLifecycleOwner, Observer {
            Log.d("name", it[0].name!!)
//            for (item in it) {
//                addShoeToView(item, inflater, container)
//            }
        })

        binding.addShoeButton.setOnClickListener {
            it.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun addShoeToView(shoe: Shoe, inflater: LayoutInflater, container: ViewGroup?): View {
        var view: View = inflater.inflate(
            R.layout.shoe_item, container, false
        );
        var shoeName: TextView = view.findViewById(R.id.nameField)
        shoeName.text = shoe.name
        var shoeDesc: TextView = view.findViewById(R.id.descriptionField)
        shoeDesc.text = shoe.description
        var shoePrice: TextView = view.findViewById(R.id.sizeField)
        shoePrice.text = shoe.size.toString()
        return view;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}