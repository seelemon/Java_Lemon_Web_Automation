package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/12 17:43
 */
public class ElementWait {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("cc");
        driver.findElement(By.id("su")).click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement wy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='1']//a[contains(text(),'网易')]")));
        wy.click();

    }

}
