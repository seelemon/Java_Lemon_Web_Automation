package com.lemon.listener;

import com.lemon.base.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/25 15:47
 */
public class AllureReportListener implements IHookable {

    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        /*
        1、IHookable接口的作用：执行测试用例的时候，动态替换每一个@Test注解标注的测试方法
        2、iHookCallBack可以正常执行测试用例，将测试方法的结果保存在iTestResult
         */
        iHookCallBack.runTestMethod(iTestResult);
        //iTestResult.getThrowable获取执行用例里面的异常结果
        if (iTestResult.getThrowable()!= null){
            System.out.println("用例不通过");
            addScreenshot();

        }
    }

    @Attachment
    public byte[] addScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) BaseTest.getDriver();
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}
