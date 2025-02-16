package com.softllc.app

import android.app.Application
import com.softllc.app.di.getBaseModules
import com.softllc.location.AndroidLocationService
import com.softllc.location.LocationService
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class SoftApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@SoftApp)
            val locationModule = module {
                single<LocationService> { AndroidLocationService(get()) }
            }
            modules(getBaseModules() + locationModule)
        }
    }
}
