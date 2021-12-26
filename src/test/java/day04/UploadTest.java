package day04;

import org.omg.SendingContext.RunTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/18 20:06
 */
public class UploadTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\SEMON\\IdeaProjects\\lemon_web_automation\\src\\test\\java\\day03\\test.html");
        Thread.sleep(1000);
        WebElement ele = driver.findElement(By.id("file"));
        Actions actions = new Actions(driver);
        actions.click(ele).perform();
       //通过Runtime执行Autoit的.exe文件
       Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("C:\\Users\\SEMON\\Desktop\\AutoItTest.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
