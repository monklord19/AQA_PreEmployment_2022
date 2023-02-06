package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserReader {

    public Properties configProperties;
    public WebDriver driver;

    public BrowserReader() throws IOException {
        // reads config.properties
        configProperties = new Properties();
        FileInputStream configPropFile = new FileInputStream("/Users/pitiriciuiulian/Desktop/AQA_PreEmployment_Proiect_2022/src/main/resources/config.properties");
        configProperties.load(configPropFile);

        String browser = configProperties.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProperties.getProperty("chromepath"));
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configProperties.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        }

    }
}
