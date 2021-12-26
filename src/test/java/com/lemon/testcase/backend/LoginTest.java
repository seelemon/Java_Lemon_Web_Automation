package com.lemon.testcase.backend;

import com.lemon.base.BaseTest;
import com.lemon.config.EnvConfig;
import com.lemon.pageobject.backEndPage.BackEndLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/25 19:09
 */
public class LoginTest extends BaseTest {


    @BeforeClass
    public void setUp() throws InterruptedException {
        optionBrowser("chrome");
        targetUrl(EnvConfig.BACKEND_LOGIN);
    }

    @Test
    public void loginTest(){
        BackEndLoginPage loginPage = new BackEndLoginPage();
        loginPage.login("lemon7","lemonbest","hapi");
    }



}
