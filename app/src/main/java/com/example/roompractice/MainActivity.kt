package com.example.roompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name")
            .allowMainThreadQueries()
            .build()

        result_text.text = db.todoDAO().getAll().toString()

        add_button.setOnClickListener {
            db.todoDAO().insert(Todo(0, todo_edit.text.toString()))
            result_text.text = db.todoDAO().getAll().toString()
        }
    }
}