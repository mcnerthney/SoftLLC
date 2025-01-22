@file:OptIn(ExperimentalFoundationApi::class)

package com.softllc.fetchtest.screens.list

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.softllc.fetchtest.data.ListObject
import com.softllc.fetchtest.screens.EmptyScreenContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ListScreen() {
    val viewModel = koinViewModel<ListViewModel>()
    val objects by viewModel.objects.collectAsStateWithLifecycle()

    AnimatedContent(objects.isNotEmpty()) { objectsAvailable ->
        if (objectsAvailable) {
            ListContent(
                objects = objects
            )
        } else {
            EmptyScreenContent(Modifier.fillMaxSize())
        }
    }
}

@Composable
private fun ListContent(
    objects: List<ListObject>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        objects.forEach { listObject ->
            stickyHeader {
                ListHeader(listObject.listId.toString())
            }
            items(listObject.names) {
                ItemDetail(it)
            }
        }
    }
}

@Composable
private fun ListHeader(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize =16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    )
}

@Composable
private fun ItemDetail(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = name,
        fontSize = 14.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}

