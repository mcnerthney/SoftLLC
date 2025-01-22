package com.softllc.fetchtest.data

import kotlinx.serialization.Serializable

@Serializable
data class ItemObject(
    val id: Int,
    val listId: Int,
    val name: String?
)

@Serializable
data class ListObject(
    val listId: Int,
    val names: List<String>
)

