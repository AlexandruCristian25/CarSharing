package com.example.carsharing.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {CarShare.class}, exportSchema = false, version = 1)
@TypeConverters({DateConverter.class})
public abstract class DataBaseManager extends RoomDatabase {

    public static final String CARSHARING_DB = "CarSharing_db";
    private static DataBaseManager dataBaseManager;

    public static DataBaseManager getInstance(Context context) {
        if (dataBaseManager == null){
            synchronized (DataBaseManager.class){
                if (dataBaseManager == null) {
                    dataBaseManager = Room.databaseBuilder(context, DataBaseManager.class, "CarSharing_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return dataBaseManager;
    }

    public abstract CarShareDao getCarShareDao();
}
