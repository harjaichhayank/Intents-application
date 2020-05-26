package com.example.intentsapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private final String TAG = "com.example.intentsapplication";
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"OnStartCommand is called");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    long futureTime = System.currentTimeMillis() + 5000;
                    while(System.currentTimeMillis() < futureTime){
                        synchronized (this) {
                            try{
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG,"Service is running");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        Thread myThread = new Thread(runnable);
        myThread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"OnDestroy is called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
