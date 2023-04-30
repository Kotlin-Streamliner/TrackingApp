package com.streamliner.trackingapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.streamliner.trackingapp.R

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar : MaterialToolbar = findViewById(R.id.toolbar)
        var bottomNavigationView : BottomNavigationView = findViewById(R.id.bottomNavigationView)
        //var navHostFragment: Fragment = findViewById(R.id.navHostFragment)
        //setSupportActionBar(toolbar)
        //bottomNavigationView.setupWithNavController(navController = navHostFragment.findNavController())

    }
}