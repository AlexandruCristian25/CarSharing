package com.example.carsharing.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "CarShares")
public class CarShare implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private long id;
    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "Year")
    private int year;
    @ColumnInfo(name = "Car")
    private String car;
    @ColumnInfo(name = "StartLocation")
    private String startLocation;
    @ColumnInfo(name = "EndLocation")
    private String endLocation;

    public CarShare(long id, String name, int year, String car, String startLocation, String endLocation) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.car = car;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    @Ignore
    public CarShare(String name, int year, String car, String startLocation, String endLocation) {
        this.name = name;
        this.year = year;
        this.car = car;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int Year) {
        this.year = Year;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    @Override
    public String toString() {
        return "CarShare{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", car='" + car + '\'' +
                ", startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                '}';
    }
}
