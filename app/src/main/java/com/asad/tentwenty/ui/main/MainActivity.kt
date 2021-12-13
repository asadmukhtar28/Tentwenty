package com.asad.tentwenty.ui.main

import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.asad.tentwenty.BR
import com.asad.tentwenty.R
import com.asad.tentwenty.databinding.ActivityMainBinding
import com.asad.tentwenty.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    override fun getBindingVariable() = BR.viewModel

    override fun initUi() {
        super.initUi()

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_dashboard,
                R.id.navigation_watch,
                R.id.navigation_media_library,
                R.id.navigation_more
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bindings.navView.setupWithNavController(navController)
    }
}