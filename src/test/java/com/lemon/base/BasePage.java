package com.lemon.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/21 16:38
 */
public class BasePage {
    Logger log = Logger.getLogger(BasePage.class);

    /**
     * 等待元素是否存在并可见
     * @param by 元素定位属性及方式
     * @return 返回WebElement
     */
    public WebElement waitElementVisible(By by){
        try {
            WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(),10);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            log.error("等待元素：+"+ by +"可见失败，失败原因："+ e);
        }
     return null;
    }

    /**
     * 等待元素是否可被点击
     * @param by 元素定位属性及方式
     * @return 返回WebElement
     */
    public WebElement waitElementClickable(By by){
        try {
            WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(),10);
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            log.error("等待元素：+"+ by +"可点击失败，失败原因："+ e);
        }
       return null;
    }

    /**
     * 等待一个元素集合
     * @param by
     * @return
     */
    public List<WebElement> waitElementsVisible( By by) {
        try {
            WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), 10);
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        }catch (Exception e){
            log.error("等待元素集合：+"+ by +"可见失败，失败原因："+ e);
        }
        return null;
    }


    /**
     * 元素点击封装
     * @param by
     */
    public void click(By by,String desc){
        log.info("点击元素："+desc);
        waitElementVisible(by).click();
    }

    /**
     * 数据输入框封装
     * @param by
     * @param data 传入需要输入的数据值
     */
    public void sendKeys(By by,String data,String desc){
        waitElementVisible(by).clear();
        log.info("元素："+desc+"输入数据："+ data);
        waitElementVisible(by).sendKeys(data);
    }

    /**
     * 获取元素文本值
     * @param by
     * @return 返回元素文本
     */
    public String getElementText(By by,String desc){
        log.info("获取元素："+desc +"文本：");
        return waitElementVisible(by).getText();
    }

    public void switchToIframe(By iframeBy,String desc){
        try {
            WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), 10);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeBy));
            log.info(desc + "切换iframe："+ iframeBy);
        }catch (Exception e){
            log.error("切换iframe：+"+ iframeBy +"失败，失败原因："+ e);
        }
    }

    public void keyboard(By by, Keys key,String desc){
        try {
            Thread.sleep(1000);
            waitElementVisible(by).sendKeys(key);
            log.info("往元素："+desc+"使用键盘操作："+ key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
