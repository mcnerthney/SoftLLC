package com.softllc.fetchtest.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ItemRepository(
    private val itemApi: ItemApi,
    private val itemStorage: ItemStorage,
) {
    private val scope = CoroutineScope(SupervisorJob())

    fun initialize() {
        scope.launch {
            refresh()
        }
    }

    suspend fun refresh() {
        itemStorage.saveObjects(itemApi.getData())
    }

    fun getObjects(): Flow<List<ListObject>> = itemStorage.getObjects()
}
