package com.scottyab.configexample;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.util.Properties;

/**
 * We use the AssetPropertyManager to load in a .properties file of config that varies depending on buildType.
 * By doing it this way we are able to encrypt the .properties file in assets with DexGuard and encrpyt and hide the use of this class.
 *
 */
public class AssetPropertyManager{

    private static final String CONFIG_FLURRY = "flurry_key";
    private static final String CONFIG_FB = "facebook_app_id";
    private static final String CONFIG_BASE_URL = "base_url";
    private static final String CONFIG_CRITTERCISM_APP_ID = "crittercism_app_id";
    private static final String CONFIG_HOCKEY_APP = "hockeyapp_key";


    //in the assets dir
    private static final String PROP_FILE = "config.properties";
    private final Properties properties = new Properties();

    public AssetPropertyManager(Context context) {
        AssetManager assetManager = context.getAssets();
        try {
            properties.load(assetManager.open(PROP_FILE));
        } catch (IOException ignored) {
            //in real app you'd likely throw runtime error
        }

    }

    public String getFlurryKey() {
        return properties.getProperty(CONFIG_FLURRY);
    }

    public String getFacebookKey() {
        return properties.getProperty(CONFIG_FB);
    }

    public String getHockeyAppKey() {
        return properties.getProperty(CONFIG_HOCKEY_APP);
    }

    public String getCrittercismAppId() {
        return properties.getProperty(CONFIG_CRITTERCISM_APP_ID);
    }

    public String getAPIBaseUrl() {
        return properties.getProperty(CONFIG_BASE_URL);
    }


}