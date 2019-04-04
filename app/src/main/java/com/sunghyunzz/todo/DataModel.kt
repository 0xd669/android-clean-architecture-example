package com.sunghyunzz.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class TodoDataModel(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    var description: String,
    var done: Boolean
)
