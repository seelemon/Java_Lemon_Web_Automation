package com.lemon.pageobject.frontEndPage;

import com.lemon.base.BasePage;
import org.openqa.selenium.By;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/20 16:19
 */
public class InvestPage extends BasePage {

    //投资金额框
    By investAmountBy = By.xpath("//div[@class='in']//input[@data-url='/Invest/invest']");
    //投标按钮
    By bidButtonBy = By.xpath("//button[text()='投标']");
    //投标成功文本框
    By bidSuccessBy = By.xpath("//div[@class='layui-layer-content']//div[@class='capital_font1 note']");
    //投标成功弹窗x button
    By closeButtonBy = By.xpath("//div[@id=\"layui-layer1\"]//div[@class='close_pop']//img");

    /*
    输入投资金额
    点击投标
    返回投标成功文本值
     */
    public String bidSuccessText(String amount){
        sendKeys(investAmountBy,amount,"投资页面-投资金额");
        click(bidButtonBy,"投资页面-点击投标");
        return getElementText(bidSuccessBy,"投资页面-获取投标成功文本");
    }

    public void dismissButtonClick(){
        click(closeButtonBy,"投资页面-关闭弹窗按钮");
    }


}
