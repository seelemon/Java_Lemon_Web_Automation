package day03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/14 10:21
 */
public class SwitchTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/SEMON/IdeaProjects/lemon_web_automation/src/test/java/day03/test.html");
//        Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
//        Thread.sleep(2000);
//        alert.accept();
//        Thread.sleep(2000);
//        alert.dismiss();

//        driver.switchTo().frame("test");
//        Thread.sleep(2000);
//        driver.findElement(By.id("q")).sendKeys("bb");
//        driver.switchTo().parentFrame();
//        driver.findElement(By.id("a")).sendKeys("123");

//        driver.findElement(By.xpath("//a[text()='新闻']")).click();
//        Thread.sleep(2000);
//        Set<String> handles = driver.getWindowHandles();
//        for(String handle : handles){
//            if(driver.getCurrentUrl().equals("http://news.baidu.com/")){
//                break;
//            }else {
//                driver.switchTo().window(handle);
//            }
//        switchHandle(driver,"http://news.baidu.com/");
//        driver.findElement(By.xpath("//div[@id='channel-all']//a[text()='军事']")).click();
        WebElement ele = driver.findElement(By.id("test"));
        Select select = new Select(ele);
        select.selectByVisibleText("数学");
        Thread.sleep(2000);

        select.selectByIndex(2);

    }

    public static void switchHandle(WebDriver driver,String url) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (driver.getCurrentUrl().equals(url)) {
                break;
            } else {
                driver.switchTo().window(handle);
            }
        }
    }

}
