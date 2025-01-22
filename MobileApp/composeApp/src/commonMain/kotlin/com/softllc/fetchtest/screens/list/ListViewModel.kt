package com.softllc.fetchtest.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softllc.fetchtest.data.ItemRepository
import com.softllc.fetchtest.data.ListObject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transform

class ListViewModel(itemRepository: ItemRepository) : ViewModel() {
    val objects: StateFlow<List<ListObject>> =
        itemRepository.getObjects()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
