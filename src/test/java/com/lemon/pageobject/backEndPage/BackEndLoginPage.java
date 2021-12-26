package com.lemon.pageobject.backEndPage;

import com.lemon.base.BasePage;
import org.openqa.selenium.By;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/25 17:13
 */
public class BackEndLoginPage extends BasePage {
    //后台登录页面用户输入框
    By username = By.name("admin_name");
    //后台登录页面密码输入框
    By pwd = By.name("admin_pwd");
    //后台登录页面验证码输入框
    By code = By.name("code");
    //后台登录页面登录按钮
    By login = By.xpath("//*[text()='登陆后台']");

    public void login(String user,String password,String verifyCode){
        sendKeys(username,user,"后台登录页面-输入用户名");
        sendKeys(pwd,password,"后台登录页面-输入密码");
        sendKeys(code,verifyCode,"后台登录页面-输入验证码");
        click(login,"后台登录页面-点击登录按钮");
    }
}
