package com.sunghyunzz.todo


interface TodoServices {
    fun calculateProgress(todos: List<Todo>): Triple<Int, Int, Float> {
        val nrOfDone = todos.count { it.done }
        val nrOfTotal = todos.count()

        return Triple(nrOfDone, nrOfTotal, nrOfDone / nrOfTotal.toFloat())
    }
}
