package com.scottyab.configexample;

import android.app.Application;

/**
 * Created by scottab on 09/10/15.
 */
public class MyApp extends Application {

    private AssetPropertyManager assetPropertyManager;

    @Override
    public void onCreate() {
        super.onCreate();
        assetPropertyManager = new AssetPropertyManager(this);
    }

    public AssetPropertyManager getAssetPropertyManager() {
        return assetPropertyManager;
    }
}
