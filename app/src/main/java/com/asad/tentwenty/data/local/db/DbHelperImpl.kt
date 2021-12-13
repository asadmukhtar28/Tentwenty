package com.asad.tentwenty.data.local.db

import com.asad.tentwenty.data.local.db.helpers.BaseDbHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbHelperImpl @Inject constructor(appDatabase: AppDatabase) : BaseDbHelper(),
    DbHelper {
    init {
        mAppDatabase = appDatabase
    }
}