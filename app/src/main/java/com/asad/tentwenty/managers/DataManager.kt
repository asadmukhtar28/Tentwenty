package com.asad.tentwenty.managers

import com.asad.tentwenty.data.local.db.DbHelper
import com.asad.tentwenty.data.remote.AppService
import com.asad.tentwenty.utils.ResourceProvider

interface DataManager {
    fun getApiHelper(): AppService
    fun getResourceManager(): ResourceProvider
    fun getDbHelper(): DbHelper
}