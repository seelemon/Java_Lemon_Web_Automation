package com.lemon.config;

/**
 * @author Automation engineer
 * @Description The God of automation
 * @Date 2021/12/20 13:56
 */
public class EnvConfig {
    //域名
    public static final String BASE_URI = "http://8.129.91.152:8765";
    //前台登录网址
    public static final String LOGIN_URL = BASE_URI + "/Index/login.html";
    //后台登录网址
    public static final String BACKEND_LOGIN = BASE_URI + "/Admin/Index/login.html";
    //谷歌driver路径
    public static final String OPTION_DRIVER_WINDOWS = "src/test/resources/chromedriver.exe";
    public static final String OPTION_DRIVER_LINUX = "src/test/resources/chromedriver";

}
