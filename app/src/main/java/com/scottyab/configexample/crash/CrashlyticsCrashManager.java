package com.scottyab.configexample.crash;

import android.content.Context;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.scottyab.configexample.BuildConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by scottab on 12/10/15.
 */
public class CrashlyticsCrashManager implements CrashManager {

    public CrashlyticsCrashManager(Context context){
        Fabric.with(context, new Crashlytics());
    }

    @Override
    public void logHandledError(String msg){
        Crashlytics.log(msg);
    }

    @Override
    public void logHandledError(Exception e){
        Log.i(CrashlyticsCrashManager.class.getSimpleName(), "logging Exception:" +e.getMessage());
        Crashlytics.getInstance().core.setString("ENVIRONMENT", BuildConfig.BUILD_TYPE);
        Crashlytics.logException(e);
    }

    public void crash(){
        Crashlytics.getInstance().crash();
    }

}
