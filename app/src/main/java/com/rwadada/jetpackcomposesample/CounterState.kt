package com.rwadada.jetpackcomposesample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

// Stateはまとまりのある１単位でまとめる（ScrollableStateとかが妥当な切り方な気がする）
data class CounterState(
    val count: Int,
    val increment: () -> Unit,
    val decrement: () -> Unit
)

// こう言った戻り値付きのComposable関数をFactory関数と呼ぶ
@Composable
fun rememberCounterState(repository: CounterRepository): CounterState {
    var count by rememberSaveable { mutableStateOf(0) } // Saveableにすることで、画面回転に対応できる（Parcelableである必要がある）
    return remember(count) {
        CounterState(
            count = count,
            increment = { count = repository.increment(count) },
            decrement = { count = repository.decrement(count) }
        )
    }
}
