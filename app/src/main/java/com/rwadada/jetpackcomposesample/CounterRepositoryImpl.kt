package com.rwadada.jetpackcomposesample

class CounterRepositoryImpl : CounterRepository {
    override fun decrement(count: Int): Int = count - 1
    override fun increment(count: Int): Int = count + 1
}
