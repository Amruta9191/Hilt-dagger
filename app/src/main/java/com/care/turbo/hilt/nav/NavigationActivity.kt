package com.care.turbo.hilt.nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.care.turbo.hilt.R
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
//        setSupportActionBar(toolbar)
     /*   val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
       // val navController = navHostFragment.navController
       val navController = Navigation.findNavController(this,R.id.fragment)*/

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(navigation,navController)// transaction of fragment
        NavigationUI.setupActionBarWithNavController(this,navController,drawer_layout)// selected fragment title to toolbar

    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawer_layout)
    }
}