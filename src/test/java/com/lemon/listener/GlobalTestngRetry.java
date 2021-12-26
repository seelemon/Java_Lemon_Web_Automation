package com.lemon.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/25 16:45
 */
public class GlobalTestngRetry implements IAnnotationTransformer {
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //getRetryAnalyzer()得到RetryAnalyzer配置对象，如果有在单个用例中配置的话iRetryAnalyzer不为空
        IRetryAnalyzer iRetryAnalyzer = annotation.getRetryAnalyzer();
        if (iRetryAnalyzer == null){
            annotation.setRetryAnalyzer(TestngRetry.class);
        }
    }
}
