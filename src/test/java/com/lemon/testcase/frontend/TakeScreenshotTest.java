package com.lemon.testcase.frontend;

import com.lemon.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/25 11:00
 */
public class TakeScreenshotTest extends BaseTest {

    @BeforeClass
    public void setUp(){
        optionBrowser("chrome");
        targetUrl("https://www.baidu.com/");
    }

    @Test
    public void testScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        //使用参数输出指定截图类型，1、File类型，2、字节数组
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File localFile = new File("D:\\screenshot\\test.png");
        //getScreenshotAs(OutputType.FILE)得到的文件对象并不是本地图片文件，需要把file转成本地文件
        //通过第三方工具依赖Commons-io
        FileUtils.copyFile(srcFile,localFile);
    }
}
