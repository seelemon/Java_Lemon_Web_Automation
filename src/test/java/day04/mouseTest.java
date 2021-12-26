package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/18 17:59
 */
public class mouseTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
        WebElement element1 = driver.findElement(By.id("treeDemo_1_span"));
        WebElement element2 = driver.findElement(By.id("treeDemo_11_span"));
        Actions action = new Actions(driver);
        action.clickAndHold(element1).moveToElement(element2).release().perform();

    }
}
