package com.lemon.testcase.frontend;

import com.lemon.base.BaseTest;
import com.lemon.config.EnvConfig;
import com.lemon.pageobject.backEndPage.BackEndIndexPage;
import com.lemon.pageobject.backEndPage.BackEndLoginPage;
import com.lemon.pageobject.backEndPage.LoanManagePage;
import com.lemon.pageobject.frontEndPage.AccountDetailPage;
import com.lemon.pageobject.frontEndPage.IndexPage;
import com.lemon.pageobject.frontEndPage.InvestPage;
import com.lemon.pageobject.frontEndPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/20 16:44
 */
public class InvestTest extends BaseTest {

    @BeforeClass
    @Parameters({"browserName"})
    public void setUp(String browserName){
        optionBrowser(browserName);
        targetUrl(EnvConfig.BACKEND_LOGIN);
        //后台登录
        BackEndLoginPage login = new BackEndLoginPage();
        login.login("lemon7","lemonbest","hapi");
        //选择借款管理
        BackEndIndexPage backEndIndexPage = new BackEndIndexPage();
        backEndIndexPage.clickLoanItem();
        //加标
        LoanManagePage loanManagePage = new LoanManagePage();
        String loanTile = "韭菜" + System.currentTimeMillis();
        loanManagePage.addLoan("18770636562",loanTile,"10","5","100000","10","1000","cc","搓澡","15");
        //审核
        loanManagePage.auditItem(loanTile);
        //跳转前台页面
        targetUrl(EnvConfig.LOGIN_URL);
    }

    @AfterClass
    public void tearDown() {
        quitBrowser();
    }

    @Test
    public void investTest() throws InterruptedException {
        //登录
        LoginPage loginPage = new LoginPage();
        loginPage.login("13323234545","lemon123456");

        //保存投标前的金额
        IndexPage indexPage = new IndexPage();
        indexPage.myAccountClick();
        AccountDetailPage detailPage = new AccountDetailPage();
        String BeforeLeaveAmount = detailPage.leaveAmountText();
       //返回首页投标
        detailPage.mainPageClick();
        indexPage.bid();
        //投标
        InvestPage investPage = new InvestPage();
        String actualValue = investPage.bidSuccessText("1000");
        Assert.assertEquals(actualValue,"投标成功！");
        //返回用户信息页面重新获取投标后金额
        investPage.dismissButtonClick();
        indexPage.myAccountClick();
        String afterLeaveAmount = detailPage.leaveAmountText();
        BigDecimal bigDecimal1 = new BigDecimal(BeforeLeaveAmount);
        BigDecimal bigDecimal2 = new BigDecimal("1000");
        String leaveAmountExpectedValue = bigDecimal1.subtract(bigDecimal2).toString();
        //断言
        Assert.assertEquals(afterLeaveAmount,leaveAmountExpectedValue);

    }
}
