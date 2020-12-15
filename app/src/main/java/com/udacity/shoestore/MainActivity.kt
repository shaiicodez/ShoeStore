package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setContentView(binding.root)

        // Set up nav controller
        setSupportActionBar(binding.toolbar);
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupWithNavController(binding.toolbar, navController)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        Timber.plant(Timber.DebugTree())
    }

    /** Lifecycle methods  **/
    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called!!")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called!!")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called!!")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called!!")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called!!")
    }


}
