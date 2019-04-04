package com.sunghyunzz.todo

import io.reactivex.Maybe
import io.reactivex.Single

interface TodoGateway {
    fun get(): Single<List<Todo>>
    fun get(id: Int): Maybe<Todo>
    fun add(description: String, done: Boolean): Single<Todo>
}
