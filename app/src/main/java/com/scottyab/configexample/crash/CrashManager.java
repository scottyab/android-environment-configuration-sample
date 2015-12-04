package com.scottyab.configexample.crash;

/**
 * Created by scottab on 12/10/15.
 */
public interface CrashManager {
    void logHandledError(String msg);

    void logHandledError(Exception e);

}
