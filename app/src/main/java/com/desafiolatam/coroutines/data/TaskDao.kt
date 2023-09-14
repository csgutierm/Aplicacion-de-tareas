package com.desafiolatam.coroutines.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * NO MODIFICAR
 */

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getTasks(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTask(taskEntity: TaskEntity)

    @Query("DELETE FROM task WHERE id= :taskId")
    suspend fun deleteTask(taskId: Int)

    @Query("UPDATE task SET completada = :completadaValue  WHERE id = :taskId")
    suspend fun updateTaskCompleted(taskId: Int, completadaValue: Boolean)
    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

    @Query("DELETE FROM task")
    suspend fun deleteAllTasks()


}