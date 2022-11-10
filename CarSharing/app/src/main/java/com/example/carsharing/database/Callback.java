package com.example.carsharing.database;

public interface Callback<R> {
    void runResultOnUiThread(R result);
}
