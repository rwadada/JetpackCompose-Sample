package com.rwadada.jetpackcomposesample

interface CounterRepository {
    fun increment(count: Int): Int
    fun decrement(count: Int): Int
}
