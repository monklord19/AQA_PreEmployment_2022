package selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import selenium.Utils.PropertiesUtil;

import java.util.Properties;

import static selenium.Utils.GetBrowserDriver.getBrowserDriver;

public class BaseClass {

    public static WebDriver driver;
    static Properties properties = PropertiesUtil.loadApplicationProperties();
    static Properties props = PropertiesUtil.loadFrameworkProperties();


    public static void initializeDriver (){
        String url = properties.getProperty("application.url");
        String browser = props.getProperty("browser.driver");

        getBrowserDriver(browser);
        WebDriverManager.chromedriver().setup();

        driver = getBrowserDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
    }


    public static void closeDriver(){
        driver.quit();
    }
}
