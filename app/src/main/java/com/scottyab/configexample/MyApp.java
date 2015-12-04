package com.scottyab.configexample;

import android.app.Application;

import com.scottyab.configexample.crash.CrashManager;
import com.scottyab.configexample.crash.CrashlyticsCrashManager;
import com.scottyab.configexample.crash.CrittercismCrashManager;
import com.scottyab.configexample.crash.HockeyAppCrashManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scottab on 09/10/15.
 */
public class MyApp extends Application {

    private static MyApp SELF = null;
    private AssetPropertyManager assetPropertyManager;
    private List<CrashManager> crashManagers;

    public MyApp() {
        SELF=this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        assetPropertyManager = new AssetPropertyManager(this);
        initCrashManagers();
    }

    private void initCrashManagers() {
        crashManagers = new ArrayList<>(3);
        crashManagers.add(new CrashlyticsCrashManager(this));
        crashManagers.add(new CrittercismCrashManager(this));
        crashManagers.add(new HockeyAppCrashManager(this));
    }

    public static MyApp getInstance() {
        return SELF;
    }

    public void handleExeption(final Exception e) {
        for(CrashManager crashManager : crashManagers){
            crashManager.logHandledError(e);
        }
    }

    public AssetPropertyManager getAssetPropertyManager() {
        return assetPropertyManager;
    }



}
