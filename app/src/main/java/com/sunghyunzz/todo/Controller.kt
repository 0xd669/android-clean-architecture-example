package com.sunghyunzz.todo

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

interface TodosController {
    fun requestAddTodo(dt: LocalDateTime): AddTodoRequest = AddTodoRequest(dt.format(dtFormat), false)

    companion object {
        private val dtFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    }
}
