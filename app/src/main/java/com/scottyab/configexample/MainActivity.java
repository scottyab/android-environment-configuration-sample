package com.scottyab.configexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.scottyab.configexample.crash.SampleManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetPropertyManager configManager = getApp().getAssetPropertyManager();

        setConfigValueToTextView(findViewById(R.id.base_url), configManager.getAPIBaseUrl());
        setConfigValueToTextView(findViewById(R.id.facebook_key), configManager.getFacebookKey());
        setConfigValueToTextView(findViewById(R.id.flurry_key), configManager.getFlurryKey());

    }

    private void setConfigValueToTextView(View textView, String valueFromConfig) {
        ((TextView)textView).setText(valueFromConfig);
    }

    public void handledCrash(View view) {
       callCrashingMethod(true);
    }

    public void crash(View view) {
        callCrashingMethod(false);
    }

    private void callCrashingMethod(boolean handleCrash) {
        SampleManager sampleManager = new SampleManager();
        try {
            sampleManager.sampleMethod("blah");
        } catch (Exception e) {
            if(handleCrash) {
                getApp().handleExeption(e);
                e.printStackTrace();
            }else{
                throw new RuntimeException(e);
            }
        }
    }

    protected MyApp getApp(){
        return (MyApp) getApplication();
    }

}
