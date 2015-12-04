package com.scottyab.configexample.crash;

/**
 * Simulate some usecase/business logic
 * Created by scottab on 12/10/15.
 */
public class SampleManager {

    public void sampleMethod(String sampleParam) throws Exception {
        privateCrashingMethod(sampleParam);
    }

    private void privateCrashingMethod(String sampleParam) throws Exception{
        CrashingExample crashingExample = new CrashingExample();
    }

}
