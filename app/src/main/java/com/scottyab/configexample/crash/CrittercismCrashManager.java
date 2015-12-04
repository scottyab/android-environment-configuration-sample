package com.scottyab.configexample.crash;


import android.content.Context;
import android.util.Log;

import com.crittercism.app.Crittercism;
import com.scottyab.configexample.MyApp;

/**
 * Created by scottab on 12/10/15.
 */
public class CrittercismCrashManager implements CrashManager {

    public CrittercismCrashManager(Context context) {
        Crittercism.initialize(context, MyApp.getInstance().getAssetPropertyManager().getCrittercismAppId());
    }

    @Override
    public void logHandledError(String msg) {
        logHandledError(new Exception(msg));
    }

    @Override
    public void logHandledError(Exception e) {
        Log.i(CrittercismCrashManager.class.getSimpleName(), "logging Exception:" + e.getMessage());
        Crittercism.logHandledException(e);
    }


}
