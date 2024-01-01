package com.example.to_docompose.data.domain.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.to_docompose.util.Constants
import kotlinx.coroutines.flow.Flow


@Dao
interface ToDoDao {

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} ORDER BY id")
    fun getAllTasks(): Flow<List<ToDoTask>>


    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} WHERE id =:taskId")
    fun getSelectedTasks(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)


    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(taskId: ToDoTask)


    @Query("DELETE FROM ${Constants.DATABASE_TABLE}")
    suspend fun deleteAllTasks()


    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>


    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoTask>>


}