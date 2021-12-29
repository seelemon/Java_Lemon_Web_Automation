package com.lemon.base;

import com.lemon.config.EnvConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/20 16:05
 */
public class BaseTest {
    Logger log = Logger.getLogger(BaseTest.class);
    //静态方法赋值，全局共享
    public WebDriver driver;

    static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
    /*
    所有测试类的父类
     */
    public void optionBrowser(String browserName){
        /*
        1、选择一个所需要的浏览器，必须是chrome、fireFox、ie
        2、如果选择的浏览器不属于三大类型，那么将返回null
        Note：暂时只支持谷歌浏览器，敬请谅解！
         */
           driver = null;
        if (browserName.equals("chrome")){
            //选择谷歌浏览器
            System.setProperty("webdriver.chrome.driver", EnvConfig.OPTION_DRIVER_LINUX);
            ChromeOptions chromeOptions= new ChromeOptions();//设置为 headless 模式 (必须)
            driver = new ChromeDriver(chromeOptions);
            threadLocal.set(driver);
            driver.manage().window().maximize();
            log.info("已打开谷歌浏览器");
        }else if (browserName.equals("fireFox")){
            //选择火狐浏览器
            System.setProperty("webdriver.gecko.driver", "src/test/resources/chromedriver.exe");
            driver = new FirefoxDriver();
            threadLocal.set(driver);
            log.info("已打开火狐浏览器");
        }else if (browserName.equals("ie")){
            ////选择IE浏览器
            //取消IE安全设置（忽略IE的Protected Mode的设置）
            //忽略IE浏览器安全设置问题
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //忽略IE浏览器缩放设置
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            System.setProperty("webdriver.ie.driver","");
            driver = new InternetExplorerDriver();
            threadLocal.set(driver);
            log.info("已打开IE浏览器");
        }
    }

    /**
     * 拿到ThreadLocal中的driver，会自动获取当中剩下的driver
     * @return driver对象
     */
    public static WebDriver getDriver(){
        return threadLocal.get();
    }
    /**
     * 去到一个目标URL
     * @param url
     */
    public void targetUrl(String url){
        log.info("打开浏览器地址："+url);
        getDriver().get(url);
    }


    public void quitBrowser(){
        getDriver().quit();
    }
}
