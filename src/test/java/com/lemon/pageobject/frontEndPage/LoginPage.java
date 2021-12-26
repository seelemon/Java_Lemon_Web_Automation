package com.lemon.pageobject.frontEndPage;

import com.lemon.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/19 22:19
 */
public class LoginPage extends BasePage {
    //手机号输入框
    By phoneBy = By.name("phone");
    //密码输入框
    By passwordBy = By.name("password");
    //登录按钮
    By loginBy = By.xpath("//button[text()='登录']");
    //登录异常元素
    By errorBy = By.xpath("//*[@class='form-error-info']");

    public void login(String mobilePhone,String pwd){
        sendKeys(phoneBy,mobilePhone,"登录页面-手机号");
        sendKeys(passwordBy,pwd,"登录页面-密码");
        click(loginBy,"登录页面-点击登录按钮");

    }

    public String errorText(){
        return getElementText(errorBy,"登录页面-获取错误信息文本值");
    }
}
