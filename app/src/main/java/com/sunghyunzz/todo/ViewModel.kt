package com.sunghyunzz.todo


data class TodoViewModel(val checked: Boolean, val shortDescription: String)

data class TodosViewModel(val todos: List<TodoViewModel>, val statusDescription: String)
