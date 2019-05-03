package com.sunghyunzz.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(vm: List<TodoViewModel>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    private val todoList : List<TodoViewModel> = vm

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var todoDescription = view.findViewById(R.id.todoDescription) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_todo ,parent,false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todoVO = todoList[position]

        holder.todoDescription.text = todoVO.shortDescription
    }
}
