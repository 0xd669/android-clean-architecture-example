package com.sunghyunzz.todo

import io.reactivex.Maybe
import io.reactivex.Single

interface TodoGatewayImpl : TodoGateway, TodoDaoProvider {
    private fun convert(d: TodoDataModel): Todo = Todo(d.id!!, d.description, d.done)

    override fun get(): Single<List<Todo>> = todoDao.get().map { it.map(::convert) }

    override fun get(id: Int): Maybe<Todo> = todoDao.get(id).map(::convert)

    override fun add(description: String, done: Boolean): Single<Todo> =
        todoDao.insert(TodoDataModel(null, description, done)).map { id ->
            Todo(id, description, done)
        }
}
