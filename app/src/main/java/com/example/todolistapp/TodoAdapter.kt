package com.example.todolistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView



class TodoAdapter (
    var todos: MutableList<Todo>
        ) :RecyclerView.Adapter<TodoAdapter.TodoViewholder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewholder {
    val view= LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewholder(view)
    }
    fun addTodo(todo: Todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }
    fun deleteDoneTodos(){
        todos.removeAll{todo ->
            todo.ischecked
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoViewholder, position: Int) {
       holder.tvtitle.text = todos[position].title
        holder.cbdone.isChecked = todos[position].ischecked
        }

    override fun getItemCount(): Int {
        return todos.size
    }
    class TodoViewholder(itemView: View):RecyclerView.ViewHolder(itemView){
        var tvtitle = itemView.findViewById<TextView>(R.id.tvTitle)
        var cbdone = itemView.findViewById<CheckBox>(R.id.cbDone)
    }
}






