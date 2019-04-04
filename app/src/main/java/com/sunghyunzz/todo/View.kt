package com.sunghyunzz.todo

import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import java.time.LocalDateTime


interface TodosView : AddTodo, GetTodos, TodoGatewayImpl, TodoDaoProvider, TodosPresenter, TodosController {

    val compositeDisposable: CompositeDisposable

    fun renderTodos(vm: TodosViewModel)

    fun handleStart(sub: Scheduler, ob: Scheduler) {
        val d = getTodos()
            .subscribeOn(sub)
            .observeOn(ob)
            .subscribe { r ->
                renderTodos(
                    presentTodos(r)
                )
            }
        compositeDisposable.add(d)
    }

    fun handleAddTodo(sub: Scheduler, ob: Scheduler) {
        val d = addTodo(requestAddTodo(LocalDateTime.now()))
            .flatMap { getTodos() }
            .subscribeOn(sub)
            .observeOn(ob)
            .subscribe { r ->
                renderTodos(
                    presentTodos(r)
                )
            }
        compositeDisposable.add(d)
    }

    fun handleDestroy() {
        compositeDisposable.dispose()
    }
}
