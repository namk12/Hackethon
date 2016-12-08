package com.certination.hackethon;

import android.app.Application;

import com.backendless.Backendless;

/**
 * Created by Deepanshu Bhatia on 20-07-2016.
 */
public class HackethonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        String appVersion = "v1";
        String applicationID = "9D52ABCE-BBBE-CFEB-FF86-38A572240500";
        String androidKey = "71C6E9AA-053E-04EC-FF24-E08AD7B8DF00";

        Backendless.initApp(this, applicationID, androidKey, appVersion);
    }
}