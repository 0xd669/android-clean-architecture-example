package com.sunghyunzz.todo

import io.reactivex.Single


interface GetTodos : TodoGateway, TodoServices {
    fun getTodos(): Single<GetTodosResult> = get().map {
        with(calculateProgress(it)) {
            GetTodosResult(
                it,
                this.first,
                this.second,
                this.third
            )
        }
    }
}


interface AddTodo: TodoGateway {
    fun addTodo(request: AddTodoRequest): Single<Todo> = add(request.description, request.done)
}
