package com.example.checkingproducts.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.example.checkingproducts.R

@Composable
fun <T> ScrollFloatingButton(
    state: LazyListState,
    coroutineScope: CoroutineScope,
    data: List<T>
) {
    Box(modifier = Modifier.fillMaxSize()) {

        /**
         * Floating action button reference
         * https://www.android--code.com/2021/04/jetpack-compose-lazycolumn-scroll-to.html
         * */
        val isTopButtonVisible = remember {
            derivedStateOf {
                state.firstVisibleItemIndex > 0
            }
        }

        FloatingActionButton(
            onClick = {
                coroutineScope.launch {
                    if (isTopButtonVisible.value) {
                        state.animateScrollToItem(0)
                    } else {
                        state.animateScrollToItem(data.size)
                    }
                }
            },
            shape = RoundedCornerShape(50),
            backgroundColor = Color(0xFFFF55A3),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(dimensionResource(id = R.dimen.dimen_16_dp))
        ) {
            if (isTopButtonVisible.value) {
                Icon(Icons.Filled.ArrowUpward, stringResource(id = R.string.scroll_up_TEXT))
            } else {
                Icon(Icons.Filled.ArrowDownward, stringResource(id = R.string.scroll_down_TEXT))
            }
        }
    }
}