package com.scottyab.configexample.crash;

import android.content.Context;
import android.util.Log;

import com.scottyab.configexample.MyApp;

import net.hockeyapp.android.CrashManagerListener;
import net.hockeyapp.android.ExceptionHandler;

/**
 * Created by scottab on 12/10/15.
 */
public class HockeyAppCrashManager  extends CrashManagerListener implements CrashManager {

    public HockeyAppCrashManager(Context context) {
        net.hockeyapp.android.CrashManager.register(context, MyApp.getInstance().getAssetPropertyManager().getHockeyAppKey(), this);
    }

    @Override
    public void logHandledError(String msg) {
        logHandledError(new Exception(msg));
    }

    @Override
    public void logHandledError(Exception e) {
        Log.i(HockeyAppCrashManager.class.getSimpleName(), "logging Exception:" + e.getMessage());
        ExceptionHandler.saveException(e, this);
    }


    @Override
    public boolean shouldAutoUploadCrashes() {
        return true;
    }

    @Override
    public boolean includeDeviceData() {
        return true;
    }

    @Override
    public boolean ignoreDefaultHandler() {
        return false;
    }
}
