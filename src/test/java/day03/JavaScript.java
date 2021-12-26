package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/14 19:27
 */
public class JavaScript {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("ad");
        Thread.sleep(2000);
//        JavascriptExecutor jSExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("document.getElementById('train_date').removeAttribute(\"readonly\")")
//        WebElement login = driver.findElement(By.xpath("//span[text()='登录']"));
//        javascriptExecutor.executeScript("arguments[0].click()",login);

        //滑动
        //a[text()='分类']
        //jSExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //Thread.sleep(2000);
//        WebElement element = driver.findElement(By.xpath("//*[text()='查看全部课程']"));
//        jSExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true)",element);
//        Thread.sleep(2000);
//        WebElement element1 = driver.findElement(By.xpath("//*[text()='入驻/合作']"));
//        jSExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true)",element1);

        //滚动到元素位置，点击更多
//        WebElement checkMore = driver.findElement(By.id("j-refresh-btn"));
//        JavascriptExecutor jSExecutor = (JavascriptExecutor) driver;
//        jSExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true)",checkMore);
//        checkMore.click();
//        Thread.sleep(2000);
//        //点击美图秀秀
//        WebElement meiTu = driver.findElement(By.xpath("//a[text()='美图秀秀']"));
//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.elementToBeClickable(meiTu));
//        meiTu.click();

        /*
        懒加载实例
        1、找到美图秀秀，循环结束
        2、如果没有找到美图秀秀，点击查看更多，继续查找
        3、如果已经没有更多，停止查找
         */
        while (true){
            if (driver.getPageSource().contains("美图秀秀x")){
                driver.findElement(By.xpath("//a[text()='美图秀秀']")).click();
                break;
            }

            try {
            driver.findElement(By.id("j-refresh-btn")).click();
            //Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("不存在此app！");
                break;
            }
        }


    }

}
