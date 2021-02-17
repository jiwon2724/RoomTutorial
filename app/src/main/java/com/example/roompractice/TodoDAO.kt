package com.example.roompractice

import androidx.room.*

@Dao
interface TodoDAO {
    @Query("SELECT * FROM Todo")
    fun getAll() : List<Todo>

    @Insert
    fun insert(todo : Todo)

    @Update
    fun update(todo : Todo)

    @Delete
    fun delete(todo : Todo)
}