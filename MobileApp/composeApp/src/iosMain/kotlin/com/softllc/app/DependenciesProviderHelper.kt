package com.softllc.app

import com.softllc.app.di.getBaseModules
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.module

class DependenciesProviderHelper {
    fun initKoin() {

        val iosModule = module {
            //your ios modules
        }

        val instance = startKoin {
            modules(getBaseModules() + iosModule)
        }

        koin = instance.koin
    }

    companion object {
        lateinit var koin: Koin
    }
}