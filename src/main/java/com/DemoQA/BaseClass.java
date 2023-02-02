package com.DemoQA;


import com.DemoQA.Utils.GetBrowserDriver;
import com.DemoQA.Utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    static Properties properties = PropertiesUtil.loadApplicationProperties();
    static Properties props = PropertiesUtil.loadFrameworkProperties();


    public static void initializeDriver (){
        String url = properties.getProperty("application.url");
        String browser = props.getProperty("browser.driver");
        driver = GetBrowserDriver.getBrowserDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
    }


    public static void closeDriver(){
        driver.quit();
    }
}
