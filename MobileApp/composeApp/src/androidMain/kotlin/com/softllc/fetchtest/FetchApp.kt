package com.softllc.fetchtest

import android.app.Application
import com.softllc.fetchtest.di.initKoin

class FetchApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
