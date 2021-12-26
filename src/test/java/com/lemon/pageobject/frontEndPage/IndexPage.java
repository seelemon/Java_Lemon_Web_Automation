package com.lemon.pageobject.frontEndPage;

import com.lemon.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/20 15:22
 */
public class IndexPage extends BasePage {
    //退出
    By existBy = By.xpath("//a[text()='退出']");
    //抢投标
    By bidBy = By.xpath("//a[text()='抢投标']");
    //我的帐户
    By myAccountBy = By.xpath("//a[@href=\"/Member/index.html\"]");

    //获取退出元素文本
    public String existText(){
        return getElementText(existBy,"首页-获取退出文本");
    }

    //点击抢投标
    public void bid(){
        waitElementsVisible(bidBy).get(0).click();
    }

    //点击我的帐户
    public void myAccountClick(){
        click(myAccountBy,"首页-点击我的帐户");
    }
}
