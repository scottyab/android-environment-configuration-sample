package com.scottyab.configexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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


    protected MyApp getApp(){
        return (MyApp) getApplication();
    }
}
