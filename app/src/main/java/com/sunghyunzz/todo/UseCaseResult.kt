package com.sunghyunzz.todo

// Response Model
data class GetTodosResult(
    val todos: List<Todo>,
    val nrOfDone: Int,
    val nrOfTotal: Int,
    val progress: Float
)
