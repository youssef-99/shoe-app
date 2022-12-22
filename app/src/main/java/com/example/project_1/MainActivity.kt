package com.example.project_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.project_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel

    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        viewModel = ViewModelProvider(this)[ViewModel::class.java]
//        val navController = findNavController(R.id.myNavHostFragment);
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =findNavController(R.id.myNavHostFragment);
        return NavigationUI.navigateUp(navController,appBarConfiguration);
    }
}