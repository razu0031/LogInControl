package com.bed.loginControl;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by abdur on 29-Oct-17.
 */

public class LogInControl extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if(FirebaseApp.getApps(this).isEmpty())
            return;
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
