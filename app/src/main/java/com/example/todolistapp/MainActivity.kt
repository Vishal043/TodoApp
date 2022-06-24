package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.internal.notify
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
todoAdapter = TodoAdapter(mutableListOf())

  val recyclerView =findViewById<RecyclerView>(R.id.rvTodos)

        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val btnADDtodo = findViewById<Button>(R.id.btnAddTodo)
        val btnDeletedoneTodos = findViewById<Button>(R.id.btnDeleteDoneTodos)
        val etTodoTitle= findViewById<EditText>(R.id.etTodoTitle)
        btnADDtodo.setOnClickListener{
            val title = etTodoTitle.text.toString()
            if(title.isNotEmpty()){
            val todo = Todo(title,false)
            todoAdapter.addTodo(todo )

            etTodoTitle.text.clear()}
        }
btnDeletedoneTodos.setOnClickListener{
todoAdapter.deleteDoneTodos()
    todoAdapter.notifyDataSetChanged()
}


    }


}