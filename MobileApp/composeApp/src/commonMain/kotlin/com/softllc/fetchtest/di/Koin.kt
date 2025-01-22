package com.softllc.fetchtest.di

import com.softllc.fetchtest.data.InMemoryItemStorage
import com.softllc.fetchtest.data.KtorItemApi
import com.softllc.fetchtest.data.ItemApi
import com.softllc.fetchtest.data.ItemRepository
import com.softllc.fetchtest.data.ItemStorage
import com.softllc.fetchtest.screens.list.ListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
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

fun initKoin() {
    startKoin {
        modules(
            dataModule,
            viewModelModule,
        )
    }
}
