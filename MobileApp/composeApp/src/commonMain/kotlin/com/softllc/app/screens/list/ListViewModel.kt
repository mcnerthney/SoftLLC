package com.softllc.app.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softllc.app.data.ItemRepository
import com.softllc.app.data.ListObject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ListViewModel(itemRepository: ItemRepository) : ViewModel() {
    val objects: StateFlow<List<ListObject>> =
        itemRepository.getObjects()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
