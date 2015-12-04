package com.scottyab.configexample.crash;

/**
 * Throws an Exception when created to help test crash reporting
 */
public class CrashingExample {

    public CrashingExample() throws Exception {
        throw new Exception("CrashingExample crash");
    }
}
