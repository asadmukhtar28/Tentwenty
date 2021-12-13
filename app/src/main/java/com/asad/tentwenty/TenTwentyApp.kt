package com.asad.tentwenty

import android.app.Application
import com.asad.tentwenty.managers.DataManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class TenTwentyApp : Application() {
    @Inject
    lateinit var dataManager: DataManager
}