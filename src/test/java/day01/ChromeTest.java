package day01;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/11/19 15:51
 */
public class ChromeTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        WebElement ele = driver.findElement(By.id("kw"));
        ele.sendKeys("1234");
//        ele.sendKeys(Keys.CONTROL,"a");
//        Thread.sleep(2000);
//        ele.sendKeys(Keys.CONTROL,"c");
//        Thread.sleep(2000);
//        ele.sendKeys(Keys.CONTROL,"v");
//        Thread.sleep(2000);
//        ele.sendKeys(Keys.CONTROL,"v");
//        System.out.println(ele.getTagName());
//        System.out.println(ele.getAttribute("name"));
//        System.out.println(ele.getText());
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getPageSource());
//        WebDriver.Navigation navigation = driver.navigate();
//        navigation.to("https://www.baidu.com");
//        navigation.refresh();
//        navigation.back();
//        navigation.forward();
        WebDriver.Window window = driver.manage().window();
        window.maximize();
        window.fullscreen();
//        Point point = window.getPosition();
//        System.out.println(point.getX());
//        System.out.println(point.getY());
//        Point point1 = new Point(100,100);
//        window.setPosition(point1);
//        System.out.println(point1.getX());
//        System.out.println(point1.getY());
        Dimension dimension = window.getSize();
        System.out.println(dimension.height);
        System.out.println(dimension.width);

        driver.quit();
    }
}
