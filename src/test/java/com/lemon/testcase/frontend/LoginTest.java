package com.lemon.testcase.frontend;

import com.lemon.base.BaseTest;
import com.lemon.pageobject.frontEndPage.IndexPage;
import com.lemon.pageobject.frontEndPage.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import com.lemon.config.*;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/19 16:53
 */
public class LoginTest extends BaseTest {
    Logger log = Logger.getLogger(LoginTest.class);

    @BeforeClass
    @Parameters({"browserName"})
    public void setUp(String browserName) {
        optionBrowser(browserName);
        targetUrl(EnvConfig.LOGIN_URL);
    }

    @AfterClass
    public void tearDown(){
        quitBrowser();
    }


    @Test()
     public void loginSuccess() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        IndexPage indexPage = new IndexPage();
        loginPage.login("13323234545","lemon123456");
        String expectValue = "退出";
        String actualValue = indexPage.existText();
        try {
            Assert.assertEquals(actualValue,expectValue);
        }catch (Exception e){
            log.error("断言失败，错误信息："+ e);
        }

    }

    @Test(dataProvider = "loginFailureData")
    public void loginFailure(String phone,String pwd,String expectValue) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(phone,pwd);
        Thread.sleep(2000);
        String actualValue = loginPage.errorText();
        Assert.assertEquals(actualValue,expectValue);
    }

    @DataProvider
    public Object[][] loginFailureData(){
        Object[][] datas = {
                {"13323234545","","请输入密码"},
                {"","lemon123456","请输入手机号"},
                {"133232345451","lemon123456","请输入正确的手机号"},
        };
        return datas;
    }

    }


