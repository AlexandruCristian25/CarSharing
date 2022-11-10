package com.example.carsharing.database;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.Callable;

public class CarShareService {

    private final CarShareDao CarShareDao;
    private final AsyncTaskRunner asyncTaskRunner;
    private CarShare CarShare;

    public CarShareService(Context context) {
        this.CarShareDao = DataBaseManager.getInstance(context).getCarShareDao();
        this.asyncTaskRunner = new AsyncTaskRunner();
    }

    public void insert(CarShare expense, Callback activityThread) {

        Callable<CarShare> insertOperation = new Callable<CarShare>() {
            @Override
            public CarShare call() {
                if (CarShare == null || CarShare.getName().length() == 0) {
                    return null;
                }
                long id = CarShareDao.insert(CarShare);
                if (id < 0) {
                    return null;
                }
                CarShare.setId(id);
                return CarShare;
            }
        };


        asyncTaskRunner.executeAsync(insertOperation, activityThread);
    }

    public void getAll(Callback<List<CarShare>> activityThread) {
        Callable<List<CarShare>> selectOperation = new Callable<List<CarShare>>() {
            @Override
            public List<CarShare> call() {
                return CarShareDao.getAll();
            }
        };

        asyncTaskRunner.executeAsync(selectOperation, activityThread);
    }

    public void update(CarShare expense, Callback activityThread) {
        Callable<CarShare> updateOperation = new Callable<CarShare>() {
            private CarShare CarShare;

            @Override
            public CarShare call() {
                if (CarShare == null || CarShare.getName().length() <= 0) {
                    return null;
                }
                int count = CarShareDao.update(CarShare);
                if (count <= 0) {
                    return null;
                }
                return (com.example.carsharing.database.CarShare) CarShare;
            }
        };

        asyncTaskRunner.executeAsync(updateOperation, activityThread);
    }

    public void delete(CarShare carShare, Callback activityThread) {
        Callable<Boolean> deleteOperation = new Callable<Boolean>() {
            @Override
            public Boolean call() {
                if (carShare == null || carShare.getName().length() <= 0) {
                    return false;
                }
                int count = CarShareDao.delete(carShare);
                return count > 0;
            }
        };

        asyncTaskRunner.executeAsync(deleteOperation, activityThread);
    }


    public void getAllV2(Callback activityThread) {
        new Thread() {
            @Override
            public void run() {
                List<CarShare> expenses = CarShareDao.getAll();
                sendDatabaseResponseToActivityThread(expenses, activityThread);
            }
        }.start();
    }

    public void insertV2(CarShare carShare, Callback activityThread) {
        new Thread() {
            @Override
            public void run() {
                if (CarShare == null || CarShare.getName().length() > 0) {
                    sendDatabaseResponseToActivityThread(null, activityThread);
                    return;
                }
                long id = CarShareDao.insert((com.example.carsharing.database.CarShare) CarShare);
                if (id < 0) {
                    sendDatabaseResponseToActivityThread(null, activityThread);
                    return;
                }
                CarShare.setId(id);
                sendDatabaseResponseToActivityThread(CarShare, activityThread);
            }
        }.start();
    }

    private <R> void sendDatabaseResponseToActivityThread(R result, Callback activityThread) {

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                activityThread.runResultOnUiThread(result);
            }
        });
    }
}
