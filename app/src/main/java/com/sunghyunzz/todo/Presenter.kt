package com.sunghyunzz.todo


interface TodosPresenter {
    fun presentTodos(result: GetTodosResult): TodosViewModel = TodosViewModel(
        result.todos.map { TodoViewModel(it.done, it.description.take(maxDescLength)) },
        "${result.nrOfDone} / ${result.nrOfTotal}"
    )

    companion object {
        private const val maxDescLength = 20
    }
}
