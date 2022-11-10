package com.example.carsharing.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CarShareDao {

    @Insert
    long insert(CarShare carShare);

    @Query("select * from CarShares")
    List<CarShare> getAll();

    @Update
    int update(CarShare carShare);

    @Delete
    int delete(CarShare carShare);
}
