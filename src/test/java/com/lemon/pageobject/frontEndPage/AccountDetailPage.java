package com.lemon.pageobject.frontEndPage;

import com.lemon.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/20 17:11
 */
public class AccountDetailPage extends BasePage {
    //可用余额
    By leaveAmountBy = By.xpath("//li[@class='color_sub']");
    //首页按钮
    By backMainPageClick = By.xpath("//div[@class='navlist clearfix fs-18']//a[text()='首页']");

    //获取可用余额并且替换中文元
    public String leaveAmountText(){
        String leaveAmount = getElementText(leaveAmountBy,"用户信息页面-获取可用余额文本");
        leaveAmount = leaveAmount.replace("元","");
        return leaveAmount;
    }

    //点击首页按钮
    public void mainPageClick(){
       click(backMainPageClick,"用户信息页面-点击返回首页按钮");
    }

}
