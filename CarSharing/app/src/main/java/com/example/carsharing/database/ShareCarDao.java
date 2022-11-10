package com.example.carsharing.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.carsharing.ShareCar;

import java.util.List;

@Dao
public interface ShareCarDao {

    @Insert
    long insert(ShareCar shareCar);

    @Query("select * from CarShares")
    List<ShareCar> getAll();

    @Update
    int update(ShareCar shareCar);

    @Delete
    int delete(ShareCar shareCar);
}