package com.softllc.fetchtest.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

interface ItemStorage {
    suspend fun saveObjects(newObjects: List<ItemObject>)
    fun getObjects(): Flow<List<ListObject>>
}

class InMemoryItemStorage : ItemStorage {
    private val storedObjects = MutableStateFlow(emptyList<ListObject>())

    override suspend fun saveObjects(newObjects: List<ItemObject>) {
        storedObjects.value = newObjects
            .asSequence() // Use sequence for lazy evaluation, better for large collections
            .filter { !it.name.isNullOrBlank() }
            .sortedBy { it.listId }
            .groupBy { it.listId }
            .map { (listId, items) ->
                ListObject(listId, items.sortedBy { it.name }.map { it.name!! })
            }
            .toList()

    }

    override fun getObjects(): Flow<List<ListObject>> = storedObjects
}
