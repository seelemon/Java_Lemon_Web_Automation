package com.lemon.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/25 16:24
 */
public class TestngRetry implements IRetryAnalyzer {
    public int retryCount = 0;
    public int maxRetryCount = 2;
    public boolean retry(ITestResult iTestResult) {
        /**
         * retry返回true表示会执行重试机制
         * retry返回false表示不会执行重试机制
         */
        if (retryCount<maxRetryCount){
            retryCount++;
            return true;
        }else {
            return false;
        }
    }
}
