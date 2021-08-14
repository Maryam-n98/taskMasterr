package com.example.taskmaster;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insertOne(Tasks tasks);

    @Query("SELECT * FROM tasks WHERE id like :id")
    Tasks findById(long id);

    @Query("SELECT * FROM Tasks")
    List<Tasks> findAll();

    @Delete
    void delete(Tasks tasks);

}
