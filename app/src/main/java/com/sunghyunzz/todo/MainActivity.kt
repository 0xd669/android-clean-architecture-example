package com.sunghyunzz.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), TodoGatewayImpl, TodoDaoProvider, TodosView {

    override val compositeDisposable: CompositeDisposable
        get() = CompositeDisposable()

    override val todoDao: TodoDao
        get() = AppDatabase.getInstance(this).todosDao()

    override fun renderTodos(vm: TodosViewModel) {
        todoList.adapter = TodoAdapter(vm)
        todoList.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            handleAddTodo(Schedulers.io(), AndroidSchedulers.mainThread())
        }

        handleStart(Schedulers.io(), AndroidSchedulers.mainThread())
    }

    override fun onDestroy() {
        super.onDestroy()
        handleDestroy()
    }
}
