package com.asad.tentwenty.managers

import com.asad.tentwenty.data.local.db.DbHelper
import com.asad.tentwenty.data.remote.AppService
import com.asad.tentwenty.utils.ResourceProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManagerImpl @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val appService: AppService,
    private val dbHelper: DbHelper
) : DataManager {

    override fun getResourceManager(): ResourceProvider {
        return resourceProvider
    }

    override fun getApiHelper(): AppService {
        return appService
    }

    override fun getDbHelper(): DbHelper {
        return dbHelper
    }
}