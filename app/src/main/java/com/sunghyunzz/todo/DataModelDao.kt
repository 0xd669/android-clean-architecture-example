package com.sunghyunzz.todo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos")
    fun get(): Single<List<TodoDataModel>>

    @Query("SELECT * FROM todos WHERE id = :id")
    fun get(id: Int): Maybe<TodoDataModel>

    @Insert
    fun insert(todo: TodoDataModel): Single<Long>
}
