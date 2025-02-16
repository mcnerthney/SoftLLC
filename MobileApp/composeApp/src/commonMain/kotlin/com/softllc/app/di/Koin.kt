package com.softllc.app.di

import com.softllc.app.data.InMemoryItemStorage
import com.softllc.app.data.KtorItemApi
import com.softllc.app.data.ItemApi
import com.softllc.app.data.ItemRepository
import com.softllc.app.data.ItemStorage
import com.softllc.app.screens.list.ListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val dataModule = module {

    single {
        val json = Json {
            ignoreUnknownKeys = true
        }
        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Any)
            }
        }
    }

    single<ItemApi> { KtorItemApi(get()) }
    single<ItemStorage> { InMemoryItemStorage() }
    single {
        ItemRepository(get(), get()).apply {
            initialize()
        }
    }

}

val viewModelModule = module {
    factoryOf(::ListViewModel)
}

fun getBaseModules() =
    listOf(dataModule, viewModelModule)

fun initKoin() {
    startKoin {
        modules(
            getBaseModules()
        )
    }
}
