package com.softllc.fetchtest.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.utils.io.CancellationException

interface ItemApi {
    suspend fun getData(): List<ItemObject>
}

class KtorItemApi(private val client: HttpClient) : ItemApi {
    companion object {
        private const val API_URL = "https://fetch-hiring.s3.amazonaws.com/hiring.json"
    }

    override suspend fun getData(): List<ItemObject> {
        return try {
            client.get(API_URL).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()

            emptyList()
        }
    }
}
